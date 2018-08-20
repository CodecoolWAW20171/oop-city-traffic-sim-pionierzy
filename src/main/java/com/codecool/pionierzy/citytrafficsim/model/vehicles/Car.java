package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Car extends Vehicle {
    public static final double CAR_ACCELERATION = 5;
    public static final double CAR_DECELERATION = 20;

    public Car(Edge road) {
        MAXSPEED = 100;
        acceleration = CAR_ACCELERATION;
        deceleration = CAR_DECELERATION;
        currentRoad = road;
        destination = road.getEnding();
    }

    public void accelerate() {
        speed += acceleration;
    }

    public void decelerate() {
        speed -= acceleration;
    }

}
