package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeDisplay extends Circle {

    private static final Color COLOR = Color.GRAY;
    private static final double R = 5.0;


    public NodeDisplay(Vertex v) {
        super(v.getX(), v.getY(), R, COLOR);
    }

}
