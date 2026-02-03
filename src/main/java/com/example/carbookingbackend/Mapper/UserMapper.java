package com.example.carbookingbackend.Mapper;

import com.example.carbookingbackend.Dto.UserInformationDto;
import com.example.carbookingbackend.Entities.UserInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    @Autowired
    private ModelMapper modelMapper;

    public UserInformationDto toDto(UserInformation userinformation){
        return  modelMapper.map(userinformation, UserInformationDto.class);
    }

    public UserInformation toEntity(UserInformationDto userinformation){
        return   modelMapper.map(userinformation, UserInformation.class);
    }
}
