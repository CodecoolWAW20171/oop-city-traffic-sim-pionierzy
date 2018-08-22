package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
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
        if (distanceTravelled + 240 * speed >= currentRoad.getLength() && speed > acceleration * 180) {
            slowDown(0.7);
            canSpeedUp = false;
        }
        if (!vehicleList.isEmpty()) {
            for (Vehicle vehicle : vehicleList) {
                if (this.distanceTravelled < vehicle.distanceTravelled && this.distanceTravelled + 120 * speed >= vehicle.distanceTravelled) {
                    if (vehicle.getSpeed() > this.speed) {
                        break;
                    }
                    if (vehicle.getSpeed() < this.speed) {
                        if (canSpeedUp == false) {
                            slowDown(0.3); // if slowed down already, can't slow down with more than 100% breaking power;
                        }
                        else {
                            slowDown(0.8);
                        }
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

    private void slowDown(Double decelerationSpeed) {
        // deceleration Speed must be a double between 0 and 1
        if (speed >= deceleration * decelerationSpeed) {
            speed -= deceleration * decelerationSpeed;
        } else {
            speed = 0;
        }
    }
    public void setRndDirection() {
        System.out.println(this.currentRoad);
        NetworkNode node = currentRoad.getEnding();
        ArrayList<NetworkNode> neighbours = node.getNeighbours();
        int size = neighbours.size();
        int index;
        do{
            index = new Random().nextInt(size);
        }while (neighbours.get(index).equals(currentRoad.getBeginning()));
        HashMap roads = node.getRoads();
        this.destination = neighbours.get(index);
        this.currentRoad.removeVehicle(this);
        this.currentRoad = (Edge) roads.get(this.destination);
        System.out.println(this.currentRoad);
        this.distanceTravelled = 0;
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

    public double getSpeed() {
        return this.speed;
    }
}
