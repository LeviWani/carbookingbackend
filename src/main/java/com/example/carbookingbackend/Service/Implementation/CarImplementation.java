package com.example.carbookingbackend.Service.Implementation;

import com.example.carbookingbackend.Dto.CarDto;
import com.example.carbookingbackend.Entities.Car;
import com.example.carbookingbackend.Mapper.CarMapper;
import com.example.carbookingbackend.Mapper.UserMapper;
import com.example.carbookingbackend.Repository.CarRepo;
import com.example.carbookingbackend.Service.Interface.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarImplementation implements CarInterface {
    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CarRepo carRepo;

    @Override
    public CarDto addCar(CarDto carDto) {
        Car temp = carMapper.toEntity(carDto);
        carRepo.save(temp);
        return carMapper.toDto(temp);
    }

    @Override
    public CarDto updateCar(Long carId, CarDto carDto) {

        Car existingCar = carRepo.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + carId));

        existingCar.setCar_brand(carDto.getCar_brand());
        existingCar.setCar_model(carDto.getCar_model());
        existingCar.setCar_year(carDto.getCar_year());
        existingCar.setCar_color(carDto.getCar_color());
        existingCar.setCar_registrationNumber(carDto.getCar_registrationNumber());
        existingCar.setCar_fuelType(carDto.getCar_fuelType());
        existingCar.setCar_transmission(carDto.getCar_transmission());

        Car updatedCar = carRepo.save(existingCar);

        return carMapper.toDto(updatedCar);
    }
    @Override
    public String deleteCar(Long carId) {
        carRepo.findById(carId);
        carRepo.deleteById(carId);
        return " car deleted";
    }

    @Override
    public CarDto getCarById(Long carId) {
        return carMapper.toDto(carRepo.findById(carId).get());
    }
    @Override
    public List<CarDto> getUsersCars(Long userId) {

        carRepo.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + userId)
                );

        List<Car> cars = carRepo.findByUser_Id(userId);

        return cars.stream()
                .map(carMapper::toDto)
                .toList();
    }



}
