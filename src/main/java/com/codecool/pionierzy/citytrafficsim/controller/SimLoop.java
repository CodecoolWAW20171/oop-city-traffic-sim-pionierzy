package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import javafx.animation.AnimationTimer;

import java.util.LinkedList;

public class SimLoop extends AnimationTimer {

    private LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();

    @Override
    public void handle(long now) {
        for (Vehicle v : vehicleList){
            v.move();
            v.getCurrentRoad().getLane().dispalayVehicle(v);//test
        }
    }

    public LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addToVehicleList(Vehicle vehicleToAdd) {
        this.vehicleList.add(vehicleToAdd);
    }

    public void removeVehicleFromList(Vehicle vehicle){
        this.vehicleList.remove(vehicle);
    }

}
