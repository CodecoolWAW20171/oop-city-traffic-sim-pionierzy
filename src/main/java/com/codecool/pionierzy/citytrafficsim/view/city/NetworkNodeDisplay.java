package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NetworkNodeDisplay extends Circle {

    public final static int radius = 60; //half of the widest connected road total width, cars should stop before (also in model)
    private static final Color color = Color.ALICEBLUE;

    public NetworkNodeDisplay(NetworkNode node, Pane pane){
        this.setCenterX(node.getX());
        this.setCenterY(node.getY());
        this.setFill(color);
        this.setRadius(radius);
        pane.getChildren().add(this);
    }

}
