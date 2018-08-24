package com.codecool.pionierzy.citytrafficsim.view.city;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class NodeDisplay extends Point2D {

    private Shape shape;
    private static final Color COLOR = Color.GRAY;
    private static final double R = 5.0;


    public NodeDisplay(double x, double y) {
        super(x, y);
        this.shape = new Circle(x, y, R, COLOR);
    }

    public Shape getShape() {
        return shape;
    }
}
