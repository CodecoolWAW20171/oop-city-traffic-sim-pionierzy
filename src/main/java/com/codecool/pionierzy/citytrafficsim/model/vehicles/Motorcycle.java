package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Motorcycle extends Vehicle {
    public static final double MOTORCYCLE_ACCELERATION = 0.006;
    public static final double MOTORCYCLE_DECELERATION = 0.016;

    public Motorcycle(Edge road) {
        MAXSPEED = 1.6;
        acceleration = MOTORCYCLE_ACCELERATION;
        deceleration = MOTORCYCLE_DECELERATION;
        currentRoad = road;
        destination = road.getEnding();
    }
}
