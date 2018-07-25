package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;

import java.util.List;

// Implements Comparable for the purposes of path finding. Right now can be ignored.
public class Edge implements Comparable {
    private NetworkNode beginning;
    private NetworkNode ending;
    private double length;

    private List<Vehicle> vehicles;

    public Edge(NetworkNode beginning, NetworkNode ending) {}

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public NetworkNode getEnding() {
        return ending;
    }

    public double getLength(){
        return length;
    }
}
