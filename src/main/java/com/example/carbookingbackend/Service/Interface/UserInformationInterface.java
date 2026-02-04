package com.example.carbookingbackend.Service.Interface;

import com.example.carbookingbackend.Dto.CreateUserDto;
import com.example.carbookingbackend.Dto.UserInformationDto;

public interface UserInformationInterface {

     UserInformationDto createUser(CreateUserDto user);
     String UpdateUser(UserInformationDto user, int id);
     String DeleteUser(UserInformationDto user);

}
