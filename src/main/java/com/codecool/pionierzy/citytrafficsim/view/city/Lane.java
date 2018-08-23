package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Car;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Motorcycle;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Truck;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class Lane extends AnchorPane {

    public static final int width = 10;
    private static final Color color = Color.GREY;
    private double height;
    private double angle;
    private Edge modelEdge;
    private final int CARWIDTH = 4;
    private final int CARHEIGHT = 10;
    private final int TWIDTH = 6;
    private final int THEIGHT = 15;
    private final int MWIDTH = 2;
    private final int MHEIGHT = 5;


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
        Rectangle vehicleView = chooseVehicleToDisplay(v);
        v.setVehicleView(vehicleView);
        this.getChildren().add(v.getVehicleView());
        this.setTopAnchor(v.getVehicleView(), this.height - v.getVehicleView().getHeight() - v.getDistanceTravelled());//it would be easier to manage with left side traffic
        this.setLeftAnchor(v.getVehicleView(), (width - v.getVehicleView().getWidth()) / 2);
        vehicleView.toFront();
        this.toBack();
    }

    private Rectangle chooseVehicleToDisplay(Vehicle v){
        if (v instanceof Car){
            Rectangle vehicleView = new Rectangle(CARWIDTH, CARHEIGHT, Color.BLUE);
            return vehicleView;
        }
        else if (v instanceof Truck){
            Rectangle vehicleView = new Rectangle(TWIDTH, THEIGHT, Color.CYAN);
            return vehicleView;
        }
        else if (v instanceof Motorcycle){
            Rectangle vehicleView = new Rectangle(MWIDTH, MHEIGHT, Color.WHITE);
            return vehicleView;
        }
        else {
            return null;
        }
    }

    public void moveVehicle(Vehicle v) {
        this.setTopAnchor(v.getVehicleView(), this.height - v.getVehicleView().getHeight() - v.getDistanceTravelled());//it would be easier to manage with left side traffic
        this.setLeftAnchor(v.getVehicleView(), (width - v.getVehicleView().getWidth()) / 2);
        v.getVehicleView().toFront();
        this.toBack();
    }

    public void setLights(LightsDisplay lightsDisplay){
        this.setTopAnchor(lightsDisplay, lightsDisplay.lights.getDistanceLocation());
        this.setLeftAnchor(lightsDisplay, 0.0);
        this.getChildren().add(lightsDisplay);
        lightsDisplay.toFront();
    }

    public void deleteCarView(Vehicle v){
        this.getChildren().remove(v.getVehicleView());
    }

    public Edge getModelEdge() {
        return modelEdge;
    }
}




