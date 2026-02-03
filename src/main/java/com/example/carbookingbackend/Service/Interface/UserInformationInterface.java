package com.example.carbookingbackend.Service.Interface;

import com.example.carbookingbackend.Dto.UserInformationDto;

public interface UserInformationInterface {

     String createUser(UserInformationDto user);
     String UpdateUser(UserInformationDto user, int id);
     String DeleteUser(UserInformationDto user);

}
