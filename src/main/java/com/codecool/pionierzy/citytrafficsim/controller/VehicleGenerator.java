package com.codecool.pionierzy.citytrafficsim.controller;

public class VehicleGenerator implements Runnable {
    private final int CAR_INTENSITY = 5;
    private final int TRUCK_INTENSITY = 2;
    private final int MOTORCYCLE_INTENSITY = 2;
    private final int INTERVAL = 10000; //10 sec

    @Override
    public void run() {
        while (true) {
            //creating vehicle for i<=INTENSITY in each edge

            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
