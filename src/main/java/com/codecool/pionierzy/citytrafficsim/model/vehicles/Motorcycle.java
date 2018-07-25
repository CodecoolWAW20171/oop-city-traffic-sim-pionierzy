package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Motorcycle extends Vehicle {
    public static final double MOTORCYCLE_ACCELERATION = 8;
    public static final double MAX_SPEED = 90;
    public static final double MOTORCYCLE_DECELERATION = 25;
    public Motorcycle(Edge road) {
        acceleration = MOTORCYCLE_ACCELERATION;
        deceleration = MOTORCYCLE_DECELERATION;
        currentRoad = road;
        destination = road.getEnding();
    }

    public void accelerate() {speed += acceleration;}

    public void decelerate() {speed -= acceleration;}

}
