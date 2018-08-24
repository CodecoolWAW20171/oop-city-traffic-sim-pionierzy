package com.codecool.pionierzy.citytrafficsim.view.city;

import javafx.scene.layout.Pane;


public class Lane extends Pane {

    private static final double WIDTH = 10;


    public Lane(double length) {
        super();
        this.setPrefHeight(length);
        this.setPrefWidth(WIDTH);
        this.getStyleClass().add("lane");
    }
}




