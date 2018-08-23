package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.lights.Lights;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import com.codecool.pionierzy.citytrafficsim.view.city.LightsDisplay;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LightsController implements Runnable {
    private ArrayList<Lights> lightsArrayList = new ArrayList<>();
    private HashMap<Lights, LightsDisplay> lightsLightsDisplayHashMap = new HashMap<>();
    private NetworkDisplay networkDisplay;

    public LightsController(NetworkDisplay networkDisplay) {
        this.networkDisplay = networkDisplay;
    }

    @Override
    public void run() {
        for (Lights lights : lightsArrayList) {
            lights.controlLightsStatus();
            lightsLightsDisplayHashMap.get(lights).setLightsColor();
            lights.setTimeLeft(lights.getTimeLeft() - 1);
        }
    }

    public void prepareLightsView() { // do this before simulating
        for (Lights lights : lightsArrayList) {
            LightsDisplay lightsDisplay = new LightsDisplay(lights, Lane.width,
                    5);
            networkDisplay.getLane(lights.getRoad()).setLights(lightsDisplay);
            lightsLightsDisplayHashMap.put(lights, lightsDisplay); // hashmap used in run()
        }
    }

    public void startScheduledExecutorService() {
        long interval = 1;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
                () -> this.run(),
                0,
                interval,
                TimeUnit.SECONDS);
    }

    public ArrayList<Lights> getLightsArrayList() {
        return lightsArrayList;
    }
}
