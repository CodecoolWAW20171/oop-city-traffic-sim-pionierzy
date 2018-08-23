package com.codecool.pionierzy.citytrafficsim.model.lights;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;

public class Lights {
    private Edge road;
    private double distanceLocation;
    private final int CYCLETIME = 10;
    private int timeLeft;
    private LightsStatus lightsStatus;
    private final int YELLOWDURATION = 1;
    private final int GREENDURATION = 4;
    //private final int GREENDURATION = Math.round((CYCLETIME - YELLOWDURATION)/2);

    public Lights(Edge road, int timeLeft) {
        this.road = road;
        this.timeLeft = timeLeft;
         this.distanceLocation = road.getLength()*0.7;
    }

    public Lights(Edge road, double distanceLocation, int timeLeft) {
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

    public void controlLightsStatus(){
        switch (timeLeft){
            case 0:
                this.timeLeft = 10;
            case CYCLETIME:
                this.lightsStatus = LightsStatus.GREEN;
                System.out.println(this + " green " + timeLeft);
                break;
            case CYCLETIME - GREENDURATION:
                this.lightsStatus = LightsStatus.YELLOW;
                System.out.println(this + " yellow " + timeLeft);
                break;
            case CYCLETIME - GREENDURATION - YELLOWDURATION:
                this.lightsStatus = LightsStatus.RED;
                System.out.println(this + " red " + timeLeft);
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
