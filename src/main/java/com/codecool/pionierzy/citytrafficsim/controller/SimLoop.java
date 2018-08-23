package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.animation.AnimationTimer;

import java.util.Iterator;
import java.util.LinkedList;

public class SimLoop extends AnimationTimer {

    private LinkedList<Vehicle> vehicleList = new LinkedList<>();
    private LinkedList<Vehicle> vehiclesToAdd = new LinkedList<>();
    private LinkedList<Vehicle> vehiclesToRemove = new LinkedList<>();
    private NetworkDisplay networkDisplay;

    public SimLoop(NetworkDisplay networkDisplay) {
        this.networkDisplay = networkDisplay;
    }

    @Override
    public void handle(long now) {
        for (Iterator<Vehicle> iterator = vehicleList.iterator(); iterator.hasNext(); ) {
            Vehicle v = iterator.next();
            v.move();
            Lane currentLane = networkDisplay.getVehicleLane(v);
            currentLane.moveVehicle(v);
            if (v.getDistanceTravelled() >= v.getCurrentRoad().getLength()) {

                currentLane.deleteCarView(v);
                if (v.getDestination().getNeighbours().size() == 1) {
                    v.getCurrentRoad().removeVehicle(v);
                    iterator.remove();
                    continue;
                }
                v.setRndDirection();
                networkDisplay.getVehicleLane(v).displayVehicle(v);
            }
        }
        vehicleList.addAll(vehiclesToAdd);
        for (Vehicle vehicle : vehiclesToRemove) {
            vehicleList.remove(vehicle);
        }
        vehiclesToAdd.clear();
        vehiclesToRemove.clear();
    }

    public synchronized void addVehicleToLane(Vehicle v) {
        networkDisplay.getVehicleLane(v).displayVehicle(v);
    }

    public synchronized LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public synchronized void addToVehicleList(Vehicle vehicleToAdd) {
        this.vehiclesToAdd.add(vehicleToAdd);
    }

    public synchronized void removeVehicleFromList(Vehicle vehicle) {
        this.vehiclesToRemove.add(vehicle);
    }

}
