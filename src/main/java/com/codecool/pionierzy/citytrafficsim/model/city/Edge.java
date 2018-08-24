package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;

import java.util.List;

public class Edge {
    private final Vertex start;
    private final Vertex end;
    private final double length;

    private List<Vehicle> vehicles;

    public Edge(Vertex start, Vertex end) {
        this(start, end, start.distanceTo(end));
    }

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

    public Edge reversed() {
        return new Edge(end, start, length);
    }

    public boolean isSameConnection(Edge other) {
        return this.equals(other) || this.equals(other.reversed());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Edge)) return false;
        Edge other = (Edge) obj;
        return other.start.equals(this.start) && other.end.equals(this.end);
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
