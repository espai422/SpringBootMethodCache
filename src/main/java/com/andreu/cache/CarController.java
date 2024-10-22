package com.andreu.cache;

import com.andreu.cache.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/car")
@AllArgsConstructor
public final class CarController {
    private final CarServiceImpl carServiceImpl;

    @GetMapping("/{brand}")
    public List<Car> index(@PathVariable String brand) {
        return carServiceImpl.getCarsByBrand(brand);
    }
}
