package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;

public abstract class Vehicle {

    private static final double MAX_SPEED = 36;
    protected double speed;
    protected double acceleration;
    protected double deceleration;

    protected NetworkNode destination;

    public Vehicle() {

    }

    public void setRndDirection() {}
}
