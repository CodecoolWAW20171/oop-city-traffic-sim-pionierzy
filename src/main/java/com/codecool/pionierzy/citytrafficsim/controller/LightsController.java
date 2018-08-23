package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.lights.Lights;
import com.codecool.pionierzy.citytrafficsim.model.lights.LightsStatus;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LightsController implements Runnable {
    private ArrayList<Lights> lightsArrayList = new ArrayList<>();

    @Override
    public void run() {
        for (Lights lights : lightsArrayList){
            lights.controlLightsStatus();
            lights.setTimeLeft(lights.getTimeLeft()-1);
        }
    }

    public void startScheduledExecutorService() {
        long interval = 1;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
                () -> this.run(),
                1,
                interval,
                TimeUnit.SECONDS);
    }

    public ArrayList<Lights> getLightsArrayList() {
        return lightsArrayList;
    }
}
