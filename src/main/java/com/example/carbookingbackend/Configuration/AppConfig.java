package com.example.carbookingbackend.Configuration;


import com.example.carbookingbackend.Entities.UserInformation;
import com.example.carbookingbackend.Mapper.CarMapper;
import com.example.carbookingbackend.Service.Implementation.UserInformationService;
import com.example.carbookingbackend.Service.Interface.UserInformationInterface;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
