package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;


public class Lane extends Pane {

    private static final double WIDTH = 10;


    public Lane(Edge edge) {
        super();
        this.setPrefHeight(edge.getLength());
        this.setPrefWidth(WIDTH);

        Vertex from = edge.from();
        Vertex to = edge.to();
        double angle = Math.toDegrees(-Math.PI / 2 +
                Math.atan2(to.getY() - from.getY(), to.getX() - from.getX()));

        Translate translate = new Translate(from.getX() - WIDTH / 2, from.getY());
        Rotate rotate = new Rotate(angle, WIDTH / 2, 0);
        this.getTransforms().addAll(translate, rotate);

        this.getStyleClass().add("lane");
    }
}




