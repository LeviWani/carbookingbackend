package com.example.carbookingbackend.Controller;


import com.example.carbookingbackend.Dto.AuthResponse;
import com.example.carbookingbackend.Dto.CreateUserDto;
import com.example.carbookingbackend.Dto.UserInformationDto;
import com.example.carbookingbackend.Entities.UserInformation;
import com.example.carbookingbackend.Service.Implementation.JwtTokenService;
import com.example.carbookingbackend.Service.Interface.UserInformationInterface;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;


@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserInformationInterface  userInformationInterface;


    public Controller(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/mobilelogin")

    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String token = jwtTokenService.generateToken(authentication.getPrincipal().toString());
        return ResponseEntity.ok(new AuthResponse(token));
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {

        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        loginRequest.email,
                        loginRequest.password()
                );

        Authentication authenticationResponse =
                authenticationManager.authenticate(authenticationRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticationResponse);


        String jwtToken = jwtTokenService.generateToken(loginRequest.email);
        System.out.println("JWT Token: " + jwtToken);

        if(jwtToken != null) {
            ResponseCookie cookie = ResponseCookie.from("jwt", jwtToken)
                    .httpOnly(true)            // inaccessible to JavaScript
                    .secure(true)              // works only over HTTPS in production
                    .sameSite("Strict")        // helps protect against CSRF
                    .path("/")                 // cookie is valid for entire site
                    .maxAge(Duration.ofHours(1)) // expiration time
                    .build();

            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        }

        return ResponseEntity.ok("Login successful");
    }

    public record LoginRequest(String email, String password) {}



    /// /
    @PostMapping("/createuser")
    public ResponseEntity<UserInformationDto> createUser(@RequestBody CreateUserDto userDto){
        UserInformationDto savedUser = userInformationInterface.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }



}
