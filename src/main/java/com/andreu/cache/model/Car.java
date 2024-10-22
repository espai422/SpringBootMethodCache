package com.andreu.cache.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;


@Value
@AllArgsConstructor
public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 425586499651057826L;

    String brand;
    String model;
    Integer doors;
    CarEngine engine;
}
