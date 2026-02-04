package com.example.carbookingbackend.Entities;

import com.example.carbookingbackend.FuelType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String carBrand;
    private String carModel;
    private Long carYear;
    private String carColor;
    private String carRegistrationNumber;

    @Enumerated(EnumType.STRING)
    private FuelType carFuelType;

    private String carTransmission;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation user;
}
