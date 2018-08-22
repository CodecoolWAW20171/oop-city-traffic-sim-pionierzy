package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;

import java.util.List;

public class Edge {
    private final Vertex start;
    private final Vertex end;
    private final double length;

    private List<Vehicle> vehicles;

    public Edge(Vertex start, Vertex end, double length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public Vertex from() {
        return start;
    }

    public Vertex to() {
        return end;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", start.v(), end.v(), length);
    }

    // Handle vehicles

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

}
