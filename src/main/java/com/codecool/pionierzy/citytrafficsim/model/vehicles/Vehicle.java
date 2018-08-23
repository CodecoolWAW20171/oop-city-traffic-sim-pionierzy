package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Vehicle {

    double speed = 0;
    double acceleration;
    double deceleration;
    Edge currentRoad;
    double MAXSPEED;
    NetworkNode destination;
    private double distanceTravelled = 0;
    private Rectangle carView;
    private Edge previousRoad;


    public void move() {
        boolean canSpeedUp = true;
        List<Vehicle> vehicleList = currentRoad.getVehicles();
        if (!vehicleList.isEmpty()) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.equals(this)) continue;
                if (vehicle.distanceTravelled > this.distanceTravelled && this.distanceTravelled + 60 * speed > vehicle.distanceTravelled) {
                    slowDown(1.0);
                    canSpeedUp = false;
                    break;
                }
                if (this.distanceTravelled + 300 * speed >= currentRoad.getLength() && vehicle.getDistanceTravelled() > this.distanceTravelled) {
                    slowDown(0.5);
                    canSpeedUp = false;
                    break;
                }
                if (this.distanceTravelled < vehicle.distanceTravelled && this.distanceTravelled + 240 * this.speed >= vehicle.distanceTravelled) {
                    slowDown(0.7);
                    canSpeedUp = false;
                    break;
                }
            }
        }
        if (distanceTravelled + 300 * speed >= currentRoad.getLength() && speed > acceleration * 180 && canSpeedUp) {
            slowDown(0.05);
            canSpeedUp = false;
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
        if (decelerationSpeed < 0.0 || decelerationSpeed > 1.0) return;
        if (speed >= deceleration * decelerationSpeed) {
            speed -= deceleration * decelerationSpeed;
        } else {
            speed = 0;
        }
    }

    public void setRndDestination() {
        NetworkNode node = currentRoad.getEnding();
        ArrayList<NetworkNode> neighbours = node.getNeighbours();
        int size = neighbours.size();
        int index;
        do {
            index = new Random().nextInt(size);
        } while (neighbours.get(index).equals(currentRoad.getBeginning()));
        this.destination = neighbours.get(index);
    }

    public NetworkNode getDestination() {
        return this.destination;
    }

    public double getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public Edge getCurrentRoad() {
        return this.currentRoad;
    }

    public Edge getPreviousRoad() {
        return previousRoad;
    }

    public Rectangle getCarView() {
        return this.carView;
    }

    public void setCarView(Rectangle carView) {
        this.carView = carView;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setPreviousRoad() {
        this.previousRoad = currentRoad;
    }

    public void setDistanceTravelledToZero() {
        this.distanceTravelled = 0;
    }

    public void setCurrentRoad() {
        this.currentRoad = currentRoad.getEnding().getRoads().get(this.destination);
    }

    public void addVehicleToCurrentRoad(Vehicle v) {
        this.currentRoad.addVehicle(v);
    }

}
