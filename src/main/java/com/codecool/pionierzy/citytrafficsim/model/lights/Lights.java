package com.codecool.pionierzy.citytrafficsim.model.lights;

import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;

public class Lights {
    private NetworkNode location;
    private int timeLeft;
    private LightsStatus lightsStatus;

    public Lights(NetworkNode location) {
        timeLeft = 10;
        lightsStatus = LightsStatus.RED;
    }
}
