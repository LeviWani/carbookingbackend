package com.example.carbookingbackend.Service.Implementation;

import com.example.carbookingbackend.Dto.UserInformationDto;
import com.example.carbookingbackend.Entities.UserInformation;
import com.example.carbookingbackend.Mapper.UserMapper;
import com.example.carbookingbackend.Repository.UserRepo;
import com.example.carbookingbackend.Service.Interface.UserInformationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInformationService  implements UserInformationInterface {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String createUser(UserInformationDto user) {
        UserInformation temp = userMapper.toEntity(user);
        userRepo.save(temp);
        return "user created";
    }


    /// /update info except password. that will be done by another method
    @Override
    public String UpdateUser(UserInformationDto user, int id) {
        UserInformation temp = userRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("user not found")
        );
        temp.setFullname(user.getFullname());
        temp.setPhoneNumber(user.getPhoneNumber());
        temp.setEmail(user.getEmail());
        temp.setAddress(user.getAddress());



        return "";
    }
//later implementation as all data should be moved to diffrent table incase of restore
    @Override
    public String DeleteUser(UserInformationDto user) {
        return "";
    }
}
