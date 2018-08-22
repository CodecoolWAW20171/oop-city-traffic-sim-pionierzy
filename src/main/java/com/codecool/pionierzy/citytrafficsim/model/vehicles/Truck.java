package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Truck extends Vehicle {
    public static final double TRUCK_ACCELERATION = 3;
    public static final double MAX_SPEED = 90;
    public static final double TRUCK_DECELERATION = 15;

    public Truck(Edge road) {
        MAXSPEED = 60;
        acceleration = TRUCK_ACCELERATION;
        deceleration = TRUCK_DECELERATION;
        currentRoad = road;
        destination = road.getEnding();
    }
}
