package com.andreu.cache;

import com.andreu.cache.cache.Cached;
import com.andreu.cache.model.Car;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    public static final String LOG_TEMPLATE = "Executed getCarsByBrand with brand: {}";
    private CarRepository carRepository;

    @Cached
    @Override
    public List<Car> getCarsByBrand(String brand) {
        log.info(LOG_TEMPLATE, brand);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return carRepository.getAll().stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
    }
}
