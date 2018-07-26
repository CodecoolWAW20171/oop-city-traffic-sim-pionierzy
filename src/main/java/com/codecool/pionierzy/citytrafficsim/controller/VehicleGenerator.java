package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Car;

import java.util.ArrayList;

public class VehicleGenerator implements Runnable{
    private final int CAR_INTENSITY = 5;
    private final int TRUCK_INTENSITY = 2;
    private final int MOTORCYCLE_INTENSITY = 2;
    private final int INTERVAL = 5000; //5 sec
    private ArrayList<Edge> startEdges = new ArrayList<Edge>();
    private SimLoop simLoop;

    public VehicleGenerator(SimLoop simLoop) {
        this.simLoop = simLoop;
    }

    @Override
    public void run() {
        while (true){
            for (Edge startEdge : startEdges) {
                Car car = new Car(startEdge);
                simLoop.addToVehicleList(car);
            }

            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToStartEdges(Edge startEdge) {
        this.startEdges.add(startEdge);
    }
}
