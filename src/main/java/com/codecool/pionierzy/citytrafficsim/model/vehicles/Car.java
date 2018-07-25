package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Car extends Vehicle {
    private static final double CAR_ACCELERATION = 5;
    private static final double MAX_SPEED = 100;
    private static final double CAR_DECELERATION = 20;
    public Car(Edge road) {
        acceleration = CAR_ACCELERATION;
        deceleration = CAR_DECELERATION;
        currentRoad = road;
    }
}
