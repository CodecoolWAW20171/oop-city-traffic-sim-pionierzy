package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public abstract class Vehicle {

    protected double speed = 0;
    protected double acceleration;
    protected double deceleration;
    protected Edge currentRoad;
    protected double MAXSPEED;
    protected double distanceTravelled = 0;
    protected NetworkNode destination;


    public void move() {
        distanceTravelled += speed;
        if (distanceTravelled >= currentRoad.getLength()) {
            setRndDirection();
        }
        if (speed < MAXSPEED - acceleration ) {
            speed += acceleration;
        }
        else if (speed < MAXSPEED) {
            speed = MAXSPEED;
        }
    }

    public void setRndDirection() {
        NetworkNode node = currentRoad.getEnding();
        HashSet<NetworkNode> neighbours = node.getNeighbours();
        int size = neighbours.size();
        int item = new Random().nextInt(size);
        int i = 0;
        HashMap roads = node.getRoads();
        for(NetworkNode obj : neighbours)
        {
            if (i == item) {
                this.destination = obj;
                this.currentRoad =(Edge) roads.get(this.destination);
            }
            i++;
        }
    }
    public NetworkNode getDestination(){
        return destination;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }
}
