package com.example.carbookingbackend.Service.Interface;

import com.example.carbookingbackend.Dto.CarDto;

import java.util.List;

public interface CarInterface {
    CarDto addCar(CarDto carDto);


    CarDto updateCar(Long carId, CarDto carDto);
    String deleteCar(Long carId);
    CarDto getCarById(Long carId);
    List<CarDto> getUsersCars(Long userId);
}
