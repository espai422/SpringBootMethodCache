package com.andreu.cache.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
@AllArgsConstructor
public class CarEngine implements Serializable {
    private static final long serialVersionUID = 1637722785281167567L;

    Integer cylinders;
    List<String> pieces;
}
