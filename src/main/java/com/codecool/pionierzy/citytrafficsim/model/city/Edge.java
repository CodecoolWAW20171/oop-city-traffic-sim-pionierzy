package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import javafx.scene.layout.Pane;

import java.util.List;

public class Edge {
    private final int v;
    private final int w;
    private final double length;

    private List<Vehicle> vehicles;

    public Edge(int v, int w, double length) {
        this.v = v;
        this.w = w;
        this.length = length;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, length);
    }

    // Handle vehicles

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

}
