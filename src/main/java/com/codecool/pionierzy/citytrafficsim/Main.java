package com.codecool.pionierzy.citytrafficsim;

import com.codecool.pionierzy.citytrafficsim.controller.MainController;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
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
        MainController mainController = new MainController();
        mainController.setPrimaryStage(primaryStage);
        NetworkDisplay networkDisplay = new NetworkDisplay();
        mainController.startNewSimulation(networkDisplay);
        primaryStage.setScene(new Scene(networkDisplay, 900, 600));
        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }
}
