package com.codecool.pionierzy.citytrafficsim.view.city;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class NetworkDisplay extends Pane {
    private HashMap<String, Image> images = new HashMap<>();

    private loadImages() {
        images.put("TRUCK", new Image("truck.jpg"))
        images.put("CAR", new Image("car.jpg"))
        images.put("MOTORCYCLE", new Image("motorcycle.jpg"))
    }
}
