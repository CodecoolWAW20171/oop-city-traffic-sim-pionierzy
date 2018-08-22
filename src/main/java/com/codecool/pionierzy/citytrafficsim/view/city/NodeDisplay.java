package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class NodeDisplay extends Circle {

    private static final Color color = Color.GRAY;
    private static final double R = 5.0;


    public NodeDisplay(Vertex v) {
        super(v.getX(), v.getY(), R, color);
//        this.setLayoutX(x);
//        this.setLayoutY(y);
    }

}
