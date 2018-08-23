package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.lights.Lights;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class LightsDisplay extends Rectangle {
    protected Lights lights;
    private final Color GREEN = Color.LIGHTGREEN;
    private final Color YELLOW = Color.YELLOW;
    private final Color RED = Color.RED;

    public LightsDisplay(Lights lights) {
        super(60, 5, Color.LIGHTGREEN);
        this.lights = lights;
    }

    public LightsDisplay(Lights lights, double width, double height) {
        super(width, height, Color.LIGHTGREEN);
        this.lights = lights;
    }

    public LightsDisplay(double width, double height, Paint fill, Lights lights) {
        super(width, height, fill);
        this.lights = lights;
    }

    public void setLightsColor() {
        switch (lights.getLightsStatus()){
            case GREEN:
                this.setFill(GREEN);
                break;
            case YELLOW:
                this.setFill(YELLOW);
                break;
            case RED:
                this.setFill(RED);
                break;
        }
    }

    public void setLights(Lights lights) {
        this.lights = lights;
    }

    public Lights getLights() {
        return lights;
    }
}
