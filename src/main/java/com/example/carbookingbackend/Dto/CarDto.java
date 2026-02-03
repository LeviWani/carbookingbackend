package com.example.carbookingbackend.Dto;

import com.example.carbookingbackend.FuelType;
import lombok.Data;

@Data
public class CarDto {
    private Long car_id;
    private String car_brand;
    private String car_model;
    private Long car_year;
    private String car_color;
    private String car_registrationNumber;
    private FuelType car_fuelType;
    private String  car_transmission; ///either aautomatic or manual


}
