package com.codecool.pionierzy.citytrafficsim.model.lights;

import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;

public class Lights {
    private NetworkNode location;
    private int phaseTime = 10;
    private int timeLeft;
    private LightsStatus lightsStatus;
    private final int YELLOWDURATION = 1;
    private final int GREENDURATION = Math.round((phaseTime - YELLOWDURATION)/2);

    public Lights(NetworkNode location) {
        this.location = location;
        this.timeLeft = 10;
        lightsStatus = LightsStatus.RED;
    }

    public Lights(NetworkNode location, int timeLeft, LightsStatus lightsStatus) {
        this.location = location;
        this.timeLeft = timeLeft;
        this.lightsStatus = lightsStatus;
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
        switch (this.getLightsStatus()){
            case GREEN:
                if (timeLeft == YELLOWDURATION){
                    this.lightsStatus = LightsStatus.YELLOW;
                    System.out.println("yellow");
                }
                break;
            case YELLOW:
                if (timeLeft == 0){
                    this.lightsStatus = LightsStatus.RED;
                    System.out.println("red");
                    timeLeft = phaseTime;
                }
                break;
            case RED:
                if (timeLeft == phaseTime - GREENDURATION){
                    this.lightsStatus = LightsStatus.GREEN;
                    System.out.println("green");
                }
                break;
        }
    }
}
