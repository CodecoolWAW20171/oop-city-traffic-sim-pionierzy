package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.lights.Lights;
import com.codecool.pionierzy.citytrafficsim.model.lights.LightsStatus;

import java.util.ArrayList;

public class LightsController implements Runnable {
    private ArrayList<Lights> lightsArrayList = new ArrayList<>();

    @Override
    public void run() {
        for (Lights lights : lightsArrayList){
            lights.controlLightsStatus();
            lights.setTimeLeft(lights.getTimeLeft()-1);
        }
    }

    public ArrayList<Lights> getLightsArrayList() {
        return lightsArrayList;
    }
}
