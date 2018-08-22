package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class Lane extends StackPane {

    private static final int width = 20;
    private static final Color color = Color.GRAY;
    private double height;
    private double angle;


    public Lane(Edge edge) {
        this.height = edge.getLength();
    }
}




