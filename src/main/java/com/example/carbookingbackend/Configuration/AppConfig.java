package com.example.carbookingbackend.Configuration;


import com.example.carbookingbackend.Entities.UserInformation;
import com.example.carbookingbackend.Mapper.CarMapper;
import com.example.carbookingbackend.Service.Implementation.JwtTokenService;
import com.example.carbookingbackend.Service.Implementation.UserInformationService;
import com.example.carbookingbackend.Service.Interface.UserInformationInterface;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class AppConfig {

    @Bean
    public CarMapper carMapper() {
        return new CarMapper();
    }
    @Bean
    public UserInformationService userInformationService() {
        return new UserInformationService();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public AuthenticationManager aunthenticationManager(){
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return null;
            }
        };
    }
    @Bean
    public JwtTokenService jwtTokenService() {
        return new JwtTokenService();
    }


}
