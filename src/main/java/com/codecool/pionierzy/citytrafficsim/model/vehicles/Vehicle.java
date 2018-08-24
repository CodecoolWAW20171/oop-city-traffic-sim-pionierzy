package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.model.lights.Lights;
import com.codecool.pionierzy.citytrafficsim.model.lights.LightsStatus;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Vehicle {

    double acceleration;
    double deceleration;
    Edge currentRoad;
    double MAXSPEED;
    NetworkNode destination;
    private double speed = 0;
    private double distanceTravelled = 0;
    private Rectangle vehicleView;


    public void move() {
        boolean canSpeedUp = true;
        Lights light = getCurrentRoad().getTrafficLight();
        double lightsDistance = 1.5 * 15;
        List<Vehicle> vehicleList = this.currentRoad.getVehicles();

        if (light != null && light.getLightsStatus() != LightsStatus.GREEN) {
            if (this.distanceTravelled == this.currentRoad.getLength() - lightsDistance && light.getLightsStatus() == LightsStatus.RED) {
                speed = 0;
                canSpeedUp = false;
            } else if (this.distanceTravelled + 120 * speed > this.currentRoad.getLength() - lightsDistance && this.distanceTravelled < this.currentRoad.getLength() && light.getLightsStatus() == LightsStatus.RED) {
                slowDown(0.6);
                canSpeedUp = false;
            } else if (this.distanceTravelled + 360 * speed > this.currentRoad.getLength() - lightsDistance && this.distanceTravelled < this.currentRoad.getLength()) {
                slowDown(0.1);
                canSpeedUp = false;
            }

        }
        if (!vehicleList.isEmpty()) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.equals(this)) continue;
                if (vehicle.getSpeed() < acceleration * 15 && vehicle.getDistanceTravelled() > this.distanceTravelled && this.distanceTravelled + speed * 30 > vehicle.getDistanceTravelled()) {
                    speed = 0;
                    break;
                }
                if (this.distanceTravelled < vehicle.distanceTravelled && this.distanceTravelled + 45 * speed > vehicle.distanceTravelled) {
                    slowDown(0.9);
                    canSpeedUp = false;
                    break;
                }
                if (this.distanceTravelled < vehicle.distanceTravelled && this.distanceTravelled + 120 * this.speed >= vehicle.distanceTravelled) {
                    if (vehicle.getSpeed() <= this.speed) {
                        if (this.distanceTravelled + 45 * speed >= vehicle.getDistanceTravelled()) {
                            slowDown(1.0);
                        } else {
                            slowDown(0.6);
                        }
                    } else {
                        if (this.distanceTravelled + 30 * speed >= vehicle.getDistanceTravelled()) {
                            slowDown(1.0);
                        } else if (this.distanceTravelled + 60 * speed >= vehicle.getDistanceTravelled()) {
                            slowDown(0.4);
                        }
                    }
                    canSpeedUp = false;
                    break;
                }
            }
        }
        if (distanceTravelled + 90 * speed >= currentRoad.getLength() && canSpeedUp) {
            if (speed > acceleration * 180) {
                slowDown(0.2);
                canSpeedUp = false;
            }
        }

        if (distanceTravelled + 90 * speed >= currentRoad.getLength() && canSpeedUp) {
            if (speed > acceleration * 180) {
                slowDown(0.2);
                canSpeedUp = false;
            }
        } else if (distanceTravelled + 300 * speed >= currentRoad.getLength() && canSpeedUp) {
            if (speed > acceleration * 300) {
                slowDown(0.05);
                canSpeedUp = false;
            }
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

    public void setRndDirection() {
        NetworkNode node = currentRoad.getEnding();
        ArrayList<NetworkNode> neighbours = node.getNeighbours();
        int size = neighbours.size();
        int index;
        do {
            index = new Random().nextInt(size);
        } while (neighbours.get(index).equals(currentRoad.getBeginning()));
        HashMap roads = node.getRoads();
        this.destination = neighbours.get(index);
        this.currentRoad.removeVehicle(this);
        this.distanceTravelled = 0;
        this.currentRoad = (Edge) roads.get(this.destination);
        this.currentRoad.addVehicle(this);
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

    public Rectangle getVehicleView() {
        return this.vehicleView;
    }

    public void setVehicleView(Rectangle vehicleView) {
        this.vehicleView = vehicleView;
    }

    public double getSpeed() {
        return this.speed;
    }
}
