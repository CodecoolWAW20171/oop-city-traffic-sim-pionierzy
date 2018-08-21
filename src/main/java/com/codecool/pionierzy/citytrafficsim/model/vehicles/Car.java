package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Car extends Vehicle {
    public static final double CAR_ACCELERATION = 0.2;
    public static final double CAR_DECELERATION = 0.6;

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
