package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Truck extends Vehicle {
    public static final double TRUCK_ACCELERATION = 0.001;
    public static final double TRUCK_DECELERATION = 0.010;

    public Truck(Edge road) {
        MAXSPEED = 0.8;
        acceleration = TRUCK_ACCELERATION;
        deceleration = TRUCK_DECELERATION;
        currentRoad = road;
        destination = road.getEnding();
    }
}
