package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;

public abstract class Vehicle {

    protected double speed = 0;
    protected double acceleration;
    protected double deceleration;
    protected Edge currentRoad;
    protected double MAXSPEED;
    protected double distanceTravelled = 0;
    protected Vertex destination;


//    public void move() {
//        distanceTravelled += speed;
//        if (distanceTravelled >= currentRoad.getLength()) {
//            setRndDirection();
//        }
//        if (speed < MAXSPEED - acceleration ) {
//            speed += acceleration;
//        }
//        else if (speed < MAXSPEED) {
//            speed = MAXSPEED;
//        }
//    }

//    public void setRndDirection() {
//        Vertex node = currentRoad.getEnding();
//        HashSet<Vertex> neighbours = node.getNeighbours();
//        int size = neighbours.size();
//        int item = new Random().nextInt(size);
//        int i = 0;
//        HashMap roads = node.getRoads();
//        for(Vertex obj : neighbours)
//        {
//            if (i == item) {
//                this.destination = obj;
//                this.currentRoad =(Edge) roads.get(this.destination);
//            }
//            i++;
//        }
//    }
    public Vertex getDestination(){
        return destination;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public Edge getCurrentRoad() {
        return currentRoad;
    }
}
