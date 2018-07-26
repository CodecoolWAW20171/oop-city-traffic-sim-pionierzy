package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class Lane extends Rectangle {

    private static final int width = 60;
    private static final Color color = Color.GRAY;

    public Lane(Edge edge, Pane pane, boolean AZ, boolean oneLaneOnly) {
        this.setWidth(width);
        this.setHeight(edge.getLength());
        this.setFill(color);
        if(AZ){
            this.getTransforms().add(new Rotate(
                    Math.toDegrees(Math.atan2(edge.getEnding().getY() - edge.getBeginning().getY(), edge.getEnding().getX() - edge.getBeginning().getX())) - 90,
                    edge.getBeginning().getX(),
                    edge.getBeginning().getY()));
            this.setX(edge.getBeginning().getX() - (oneLaneOnly? width/2:0));
            this.setY(edge.getBeginning().getY());
        }else{
            this.getTransforms().add(new Rotate(
                    Math.toDegrees(Math.atan2(edge.getBeginning().getY() - edge.getEnding().getY(), edge.getBeginning().getX() - edge.getEnding().getX())) - 90,
                    edge.getEnding().getX(),
                    edge.getEnding().getY()));
            this.setX(edge.getEnding().getX() - (oneLaneOnly? width/2:0));
            this.setY(edge.getEnding().getY());
        }

        pane.getChildren().add(this);
    }
}


