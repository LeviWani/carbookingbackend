package com.example.carbookingbackend.Dto;

import com.example.carbookingbackend.Entities.Address;
import com.example.carbookingbackend.Entities.Car;
import lombok.Data;


@Data
public class UserInformationDto {
    private Long id;
    private String fullname;
    private Integer phoneNumber;
    private String Email;
    private String Password;
    private Address address;
    private Car car;

}
