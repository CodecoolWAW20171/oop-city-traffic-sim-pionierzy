package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;

public abstract class Vehicle {

    private static final double MAX_SPEED = 36;
    protected double speed = 0;
    protected double acceleration;
    protected double deceleration;
    protected Edge currentRoad;
    protected double distanceTravelled = 0;
    protected NetworkNode destination;


    public Vehicle() {

    }

    public void Move() {
        distanceTravelled += speed;
    }

    public void setRndDirection() {

    }
    public NetworkNode getDestination(){
        return destination;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }
}
