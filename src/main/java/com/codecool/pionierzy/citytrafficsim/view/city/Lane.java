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
    private Edge modelEdge;
    private final int CARWIDTH = 6;
    private final int CARHEIGHT = 20;


    public Lane(Edge edge, Pane pane, boolean AZ, boolean oneLaneOnly) {
        this.height = Math.sqrt(Math.pow((edge.getBeginning().getX() - edge.getEnding().getX()), 2) + Math.pow((edge.getBeginning().getY() - edge.getEnding().getY()), 2));
        this.angle = Math.toDegrees(Math.atan2(edge.getEnding().getY() - edge.getBeginning().getY(), edge.getEnding().getX() - edge.getBeginning().getX())) + 90;
        this.modelEdge = edge;

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
    public void displayVehicle(Vehicle v) {
        Rectangle car = new Rectangle(CARWIDTH, CARHEIGHT, Color.BLUE);
        v.setCarView(car);
        this.getChildren().add(v.getCarView());
        this.setTopAnchor(v.getCarView(), this.height - v.getCarView().getHeight() - v.getDistanceTravelled());//it would be easier to manage with left side traffic
        this.setLeftAnchor(v.getCarView(), (width - v.getCarView().getWidth()) / 2);
    }

    public void moveVehicle(Vehicle v) {
        this.setTopAnchor(v.getCarView(), this.height - v.getCarView().getHeight() - v.getDistanceTravelled());//it would be easier to manage with left side traffic
        this.setLeftAnchor(v.getCarView(), (width - v.getCarView().getWidth()) / 2);
    }

    public void deleteCarView(Vehicle v){
        this.getChildren().remove(v.getCarView());
    }

    public Edge getModelEdge() {
        return modelEdge;
    }
}




