package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.animation.AnimationTimer;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class SimLoop extends AnimationTimer {

    private LinkedList<Vehicle> vehicleList = new LinkedList<>();
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
                    iterator.remove();
                    continue;
                }
                v.setRndDirection();
                networkDisplay.getVehicleLane(v).displayVehicle(v);
            }
        }
    }

    public synchronized void addVehicleToLane(Vehicle v) {
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
    private boolean isTurningRight(Point beginning, Point turn, Point end){
        if(turn.getX() == beginning.getX()){     // vertical
            if(beginning.getY() > turn.getY()){  // going up
                return turn.getX() < end.getX();
            }else{                               // going down
                return turn.getX() > end.getX();
            }
        }else{                                   // horizontal
            if(beginning.getX() < turn.getX()){  // going right
                return end.getY() > turn.getY();
            }else{                               //going left
                return end.getY() < turn.getY();
            }
        }
    }
}
