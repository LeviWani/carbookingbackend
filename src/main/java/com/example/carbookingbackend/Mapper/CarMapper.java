package com.example.carbookingbackend.Mapper;

import com.example.carbookingbackend.Dto.CarDto;
import com.example.carbookingbackend.Entities.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    @Autowired
    private ModelMapper modelMapper;
    public CarDto toDto(Car car){
        return  modelMapper.map(car, CarDto.class);
    }

    public Car toEntity(CarDto car){
        return   modelMapper.map(car, Car.class);
    }
}
