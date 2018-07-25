package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;

import java.util.List;

// Implements Comparable for the purposes of path finding. Right now can be ignored.
public class Edge implements Comparable {
    private NetworkNode beginning;
    private NetworkNode ending;
    private double length;

    private List<Vehicle> vehicles;

    public Edge(NetworkNode beginning, NetworkNode ending) {
        this.beginning = beginning;
        this.ending = ending;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
