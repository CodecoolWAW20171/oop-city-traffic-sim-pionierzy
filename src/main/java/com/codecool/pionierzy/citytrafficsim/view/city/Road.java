package com.codecool.pionierzy.citytrafficsim.view.city;

import javafx.geometry.Point2D;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.LinkedList;
import java.util.List;

public class Road extends HBox {
    private final Point2D n1;
    private final Point2D n2;
    private List<Lane> lanes;

    public Road(NodeDisplay n1, NodeDisplay n2) {
        super();
        this.n1 = n1;
        this.n2 = n2;
        this.lanes = new LinkedList<>();
    }


    public void addLane(Lane lane) {
        lanes.add(lane);
    }

    public void display(Pane parent) {
        Translate translate = new Translate(n1.getX() - getWidth() / 2, n1.getY());
        double angle = n2.angle(n1);
        Rotate rotate = new Rotate(angle, getWidth() / 2, 0);
        this.getTransforms().addAll(translate, rotate);
        parent.getChildren().add(this);
    }
}
