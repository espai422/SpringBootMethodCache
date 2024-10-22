package com.andreu.cache;

import com.andreu.cache.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarsByBrand(String brand);
}
