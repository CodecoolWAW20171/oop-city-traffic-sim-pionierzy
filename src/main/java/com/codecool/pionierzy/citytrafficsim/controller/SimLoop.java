package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.animation.AnimationTimer;

import java.util.LinkedList;

public class SimLoop extends AnimationTimer {

    private LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();
    NetworkDisplay networkDisplay;

    public SimLoop(NetworkDisplay networkDisplay) {
        this.networkDisplay = networkDisplay;
    }

    @Override
    public void handle(long now) {
        for (Vehicle v : vehicleList) {
            v.move();
            networkDisplay.getVehicleLane(v).moveVehicle(v);//test
            if (v.getDistanceTravelled() > v.getCurrentRoad().getLength()) {
                System.out.println("change! " + v.toString());
                networkDisplay.getVehicleLane(v).displayVehicle(v);
            }
        }
    }

    public void addVehicleToLane(Vehicle v){
            networkDisplay.getVehicleLane(v).displayVehicle(v);
    }

    public LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addToVehicleList(Vehicle vehicleToAdd) {
        this.vehicleList.add(vehicleToAdd);
    }

    public void removeVehicleFromList(Vehicle vehicle) {
        this.vehicleList.remove(vehicle);
    }

}
