package com.example.carbookingbackend.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    private String country;
    private String city;
    private String area; // street name
    private String houseNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation user;
}
