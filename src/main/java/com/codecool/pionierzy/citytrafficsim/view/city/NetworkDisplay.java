package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class NetworkDisplay extends Pane {
    private HashMap<String, Image> images = new HashMap<>();
    private ArrayList<Lane> lanes = new ArrayList<>();

    private void loadImages() {
        images.put("TRUCK", new Image("truck.jpg"));
        images.put("CAR", new Image("car.jpg"));
        images.put("MOTORCYCLE", new Image("motorcycle.jpg"));
    }

    public void createLaneView(Edge edge) {
        this.lanes.add(new Lane(edge, this, true, false));
    }

    public Lane getVehicleLane(Vehicle vehicle) {
        Edge edge = vehicle.getCurrentRoad();
        for (Lane lane : this.lanes) {
            Edge lanesEdge = lane.getModelEdge();
            if (edge.equals(lanesEdge)) return lane;
        }
        return null;
    }

    public Lane getLane(Edge edge) {
        for (Lane lane : this.lanes) {
            Edge lanesEdge = lane.getModelEdge();
            if (edge.equals(lanesEdge)) return lane;
        }
        return null;
    }
}
