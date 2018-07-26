package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import javafx.scene.layout.Pane;

import java.util.List;

// Implements Comparable for the purposes of path finding. Right now can be ignored.
public class Edge implements Comparable {
    private NetworkNode beginning;
    private NetworkNode ending;
    private double length;
    private Lane lane;


    private List<Vehicle> vehicles;

    public Edge(NetworkNode beginning, NetworkNode ending) {
        this.beginning = beginning;
        this.ending = ending;
        this.length = Math.sqrt(Math.pow((beginning.getX()-ending.getX()), 2) + Math.pow((beginning.getY()-ending.getY()), 2));
    }
    public Edge(NetworkNode beginning, NetworkNode ending, Pane pane) {
        this.beginning = beginning;
        this.ending = ending;
        this.length = Math.sqrt(Math.pow((beginning.getX()-ending.getX()), 2) + Math.pow((beginning.getY()-ending.getY()), 2));
        this.createVisualDisplay(pane);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    public void createVisualDisplay(Pane pane) {
        this.lane = new Lane(this, pane, true, false);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public NetworkNode getEnding() {
        return ending;
    }

    public NetworkNode getBeginning() {
        return beginning;
    }

    public double getLength(){
        return length;
    }
}
