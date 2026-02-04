package com.example.carbookingbackend.Controller;


import com.example.carbookingbackend.Dto.CreateUserDto;
import com.example.carbookingbackend.Dto.UserInformationDto;
import com.example.carbookingbackend.Entities.UserInformation;
import com.example.carbookingbackend.Service.Interface.UserInformationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private UserInformationInterface  userInformationInterface;

    @PostMapping("/createuser")
    public ResponseEntity<UserInformationDto> createUser(@RequestBody CreateUserDto userDto){
        UserInformationDto savedUser = userInformationInterface.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }



}
