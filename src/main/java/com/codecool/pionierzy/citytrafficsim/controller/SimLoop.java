package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.animation.AnimationTimer;

import java.util.LinkedList;

public class SimLoop extends AnimationTimer {

    private LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();
    NetworkDisplay networkDisplay;
    private Lane currentLane;

    public SimLoop(NetworkDisplay networkDisplay) {
        this.networkDisplay = networkDisplay;
    }

    @Override
    public void handle(long now) {
        for (Vehicle v : vehicleList) {

            v.move();
            currentLane = networkDisplay.getVehicleLane(v);
            currentLane.moveVehicle(v);//test
            if (v.getDistanceTravelled() >= v.getCurrentRoad().getLength()) {

                currentLane.deleteCarView(v);
                if (v.getDestination().getNeighbours().size() == 1){
                    removeVehicleFromList(v);
                    continue;
                }
                v.setRndDirection();
                networkDisplay.getVehicleLane(v).displayVehicle(v);
            }
        }
    }

    public void addVehicleToLane(Vehicle v){
            networkDisplay.getVehicleLane(v).displayVehicle(v);
    }

    public synchronized LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public synchronized void addToVehicleList(Vehicle vehicleToAdd) {
        this.vehicleList.add(vehicleToAdd);
    }

    public synchronized void removeVehicleFromList(Vehicle vehicle) {
        this.vehicleList.remove(vehicle);
    }

}
