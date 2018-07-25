package com.codecool.pionierzy.citytrafficsim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String APP_NAME = "City Traffic Simulator by Pionierzy";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Right now just for testing run configuration
        Pane pane = new Pane();
        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }
}
