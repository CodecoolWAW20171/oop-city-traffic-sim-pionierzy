package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public abstract class Vehicle {

    double speed = 0;
    double acceleration;
    double deceleration;
    Edge currentRoad;
    double MAXSPEED;
    private double distanceTravelled = 0;
    NetworkNode destination;
    private Rectangle carView;

    public void move() {
        boolean canSpeedUp = true;
        List<Vehicle> vehicleList = currentRoad.getVehicles();
        if (!vehicleList.isEmpty()) {
            for (Vehicle vehicle : vehicleList) {
                if (this.distanceTravelled < vehicle.distanceTravelled
                        && this.distanceTravelled + 120 * speed >= vehicle.distanceTravelled) {
                    if (speed >= deceleration) {
                        speed -= deceleration;
                    } else {
                        speed = 0;
                    }
                    canSpeedUp = false;
                    break;
                }
            }
        }
        if (distanceTravelled >= currentRoad.getLength()) {
            setRndDirection();
        }
        if (canSpeedUp) {
            if (speed < MAXSPEED - acceleration) {
                speed += acceleration;
            } else if (speed < MAXSPEED) {
                speed = MAXSPEED;
            }
        }
        distanceTravelled += speed;
    }

    private void setRndDirection() {
        NetworkNode node = currentRoad.getEnding();
        HashSet<NetworkNode> neighbours = node.getNeighbours();
        int size = neighbours.size();
        int item = new Random().nextInt(size);
        int i = 0;
        HashMap roads = node.getRoads();
        for (NetworkNode obj : neighbours) {
            if (i == item) {
                this.destination = obj;
                this.currentRoad = (Edge) roads.get(this.destination);
                this.distanceTravelled = 0;
            }
            i++;
        }
    }

    public NetworkNode getDestination() {
        return destination;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public Edge getCurrentRoad() {
        return currentRoad;
    }

    public Rectangle getCarView() {
        return carView;
    }

    public void setCarView(Rectangle carView) {
        this.carView = carView;
    }
}
