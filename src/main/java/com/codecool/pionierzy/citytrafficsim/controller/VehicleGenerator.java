package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Car;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Motorcycle;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Truck;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleGenerator implements Runnable {
    private final int CAR_INTENSITY = 5;
    private final int TRUCK_INTENSITY = 2;
    private final int MOTORCYCLE_INTENSITY = 2;
    private final int INTERVAL = 2000; // sec
    private ArrayList<Edge> startEdges = new ArrayList<Edge>();
    private SimLoop simLoop;
    private Random random = new Random();
    private int randint;


    public VehicleGenerator(SimLoop simLoop) {
        this.simLoop = simLoop;
    }

    @Override
    public void run() {
        while (true) { // scheduler is needed !!!!!!!!!!
            for (Edge startEdge : startEdges) {
                randint = random.nextInt(CAR_INTENSITY + TRUCK_INTENSITY + MOTORCYCLE_INTENSITY);

                if (randint < CAR_INTENSITY) {
                    Car v = new Car(startEdge);
                    createVehicle(v, startEdge);
                }
                else if (randint < CAR_INTENSITY + TRUCK_INTENSITY){
                    Truck v = new Truck(startEdge);
                    createVehicle(v, startEdge);
                }
                else if (randint < CAR_INTENSITY + TRUCK_INTENSITY + MOTORCYCLE_INTENSITY){
                    Motorcycle v = new Motorcycle(startEdge);
                    createVehicle(v, startEdge);
                }
                else {
                    Car v = new Car(startEdge);
                    createVehicle(v, startEdge);
                }
            }

            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createVehicle(Vehicle v, Edge startEdge){
        simLoop.addToVehicleList(v);
        startEdge.addVehicle(v);
        Platform.runLater(
                // JavaFX doesn't allow modify View from non-JavaFX threads, so Platform is needed.
                () -> {
                    simLoop.addVehicleToLane(v);
                }
        );
    }

    public void addToStartEdges(Edge startEdge) {
        this.startEdges.add(startEdge);
    }

    public void generateOneCar(Edge startEdge) {
        Car car = new Car(startEdge);
        simLoop.addToVehicleList(car);
        startEdge.addVehicle(car);
        simLoop.addVehicleToLane(car);
    }


    public void startScheduledExecutorService() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
                () -> this.run(),
                0,
                INTERVAL*1000,
                TimeUnit.SECONDS);
    }
}
