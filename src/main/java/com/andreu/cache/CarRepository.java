package com.andreu.cache;

import com.andreu.cache.model.Car;
import com.andreu.cache.model.CarEngine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class CarRepository {
    private static final List<Car> cars = List.of(
            new Car("Toyota", "Corolla", 4, new CarEngine(4, List.of("Piston", "Cylinder", "Spark Plug"))),
            new Car("Toyota", "Camry", 4, new CarEngine(4, List.of("Piston", "Cylinder", "Spark Plug"))),
            new Car("Toyota", "RAV4", 4, new CarEngine(4, List.of("Piston", "Cylinder", "Spark Plug"))),

            new Car("Ferrari", "488", 2, new CarEngine(8, List.of("Piston", "Turbocharger", "Fuel Injector"))),
            new Car("Ferrari", "F8", 2, new CarEngine(8, List.of("Piston", "Turbocharger", "Fuel Injector"))),
            new Car("Ferrari", "Portofino", 2, new CarEngine(8, List.of("Piston", "Turbocharger", "Fuel Injector"))),
            new Car("Ferrari", "Roma", 2, new CarEngine(8, List.of("Piston", "Turbocharger", "Fuel Injector"))),
            new Car("Ferrari", "LaFerrari", 2, new CarEngine(12, List.of("Piston", "Electric Motor", "Turbocharger"))),

            new Car("Ford", "Mustang", 2, new CarEngine(6, List.of("Piston", "Camshaft", "Exhaust"))),
            new Car("Ford", "Fiesta", 4, new CarEngine(4, List.of("Piston", "Cylinder Head", "Crankshaft"))),
            new Car("Ford", "Focus", 4, new CarEngine(4, List.of("Piston", "Timing Belt", "Fuel Pump"))),
            new Car("Ford", "Explorer", 4, new CarEngine(6, List.of("Piston", "Timing Chain", "Exhaust"))),

            new Car("BMW", "M3", 4, new CarEngine(6, List.of("Piston", "Cylinder Block", "Oil Pump"))),
            new Car("BMW", "X5", 4, new CarEngine(6, List.of("Piston", "Turbocharger", "Fuel Injector"))),

            new Car("Honda", "Civic", 4, new CarEngine(4, List.of("Piston", "Cylinder", "Fuel System"))),
            new Car("Honda", "Accord", 4, new CarEngine(4, List.of("Piston", "Cylinder Head", "Intake Manifold"))),

            new Car("Audi", "A4", 4, new CarEngine(4, List.of("Piston", "Turbocharger", "Fuel System"))),
            new Car("Audi", "Q5", 4, new CarEngine(4, List.of("Piston", "Exhaust Manifold", "Catalytic Converter"))),

            new Car("Tesla", "Model S", 4, new CarEngine(0, List.of("Electric Motor", "Battery Pack", "Inverter"))),
            new Car("Tesla", "Model 3", 4, new CarEngine(0, List.of("Electric Motor", "Battery Pack", "Inverter")))
    );
    public List<Car> getAll() {
        return cars;
    }
}
