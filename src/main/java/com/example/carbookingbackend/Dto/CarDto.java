package com.example.carbookingbackend.Dto;

import com.example.carbookingbackend.Entities.UserInformation;
import com.example.carbookingbackend.FuelType;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CarDto {

    private Long carId;

    private String carBrand;
    private String carModel;
    private Long carYear;
    private String carColor;
    private String carRegistrationNumber;

    @Enumerated(EnumType.STRING)
    private FuelType carFuelType;

    private String carTransmission;

    private UserInformation user;


}
