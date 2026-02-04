package com.example.carbookingbackend.Dto;

import com.example.carbookingbackend.Entities.Address;
import com.example.carbookingbackend.Entities.Car;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
public class UserInformationDto {

    private Long id;

    private String fullName;
    private Integer phoneNumber;
    private String email;
    private String password;

   // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

  //  @OneToMany(mappedBy = "user")
    private List<Car> cars;

}
