package com.codecool.pionierzy.citytrafficsim.model.lights;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Lights {
    private Edge road;
    private double distanceLocation;
    private final int CYCLETIME = 10;
    private int timeLeft;
    private LightsStatus lightsStatus = LightsStatus.GREEN;
    private final int YELLOWDURATION = 1;
    private final int GREENDURATION = 4;
    //private double distanceFromEnding = 35;

    public Lights(Edge road, int timeLeft) {
        this.road = road;
        this.timeLeft = timeLeft;
        this.distanceLocation = road.getLength() * 0.65;
    }

    public Lights(Edge road, int timeLeft, double distanceLocation) {
        this.road = road;
        this.distanceLocation = distanceLocation;
        this.timeLeft = timeLeft;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public LightsStatus getLightsStatus() {
        return lightsStatus;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setLightsStatus(LightsStatus lightsStatus) {
        this.lightsStatus = lightsStatus;
    }

    public void controlLightsStatus() {
        switch (timeLeft) {
            case 0:
                this.timeLeft = 10;
            case CYCLETIME:
                this.lightsStatus = LightsStatus.GREEN;
                break;
            case CYCLETIME - GREENDURATION:
                this.lightsStatus = LightsStatus.YELLOW;
                break;
            case CYCLETIME - GREENDURATION - YELLOWDURATION:
                this.lightsStatus = LightsStatus.RED;
                break;
        }
    }

    public Edge getRoad() {
        return road;
    }

    public double getDistanceLocation() {
        return distanceLocation;
    }
}
