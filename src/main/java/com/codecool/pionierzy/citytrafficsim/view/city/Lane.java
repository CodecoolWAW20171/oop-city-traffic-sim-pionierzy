package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class Lane extends AnchorPane {

    private static final int width = 60;
    private static final Color color = Color.GRAY;
    private double height;
    private double angle;


    public Lane(Edge edge, Pane pane, boolean AZ, boolean oneLaneOnly) {
        this.height = Math.sqrt(Math.pow((edge.getBeginning().getX() - edge.getEnding().getX()), 2) + Math.pow((edge.getBeginning().getY() - edge.getEnding().getY()), 2));
        this.angle = Math.toDegrees(Math.atan2(edge.getEnding().getY() - edge.getBeginning().getY(), edge.getEnding().getX() - edge.getBeginning().getX())) + 90;

        Rectangle rect = new Rectangle(width, height, color);
        this.getChildren().add(rect);
        if (AZ) {
            this.getTransforms().add(new Rotate(angle));
            this.setLayoutX(edge.getEnding().getX() - (oneLaneOnly ? width / 2 : 0));
            this.setLayoutY(edge.getEnding().getY());
        } else {
            this.getTransforms().add(new Rotate(Math.toDegrees(Math.atan2(edge.getBeginning().getY() - edge.getEnding().getY(), edge.getBeginning().getX() - edge.getEnding().getX())) - 90));
            this.setLayoutX(edge.getBeginning().getX() - (oneLaneOnly ? width / 2 : 0));
            this.setLayoutY(edge.getBeginning().getY());
        }


        pane.getChildren().add(this);
    }

    //for tests only, animation might be based on setTopAnchor method
    public void dispalayVehicle(Vehicle v) {
        Rectangle car = new Rectangle(10, 50, Color.BLUE);
        this.getChildren().add(car);
        this.setTopAnchor(car, this.height - car.getHeight() - v.getDistanceTravelled() / 100);//it would be easier to manage with left side traffic
        this.setLeftAnchor(car, (width - car.getWidth()) / 2);
    }
}




