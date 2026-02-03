package com.example.carbookingbackend.Entities;

import com.example.carbookingbackend.FuelType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long car_id;
    private String car_brand;
    private String car_model;
    private Long car_year;
    private String car_color;
    private String car_registrationNumber;
    private FuelType car_fuelType;
    private String  car_transmission; ///either aautomatic or manual



}
