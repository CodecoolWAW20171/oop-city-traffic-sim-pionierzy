package com.codecool.pionierzy.citytrafficsim;

import com.codecool.pionierzy.citytrafficsim.controller.MainController;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static final String APP_NAME = "City Traffic Simulator by Pionierzy";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MainController.FXML));
        Parent root = loader.load();

        MainController mainController = loader.getController();
        mainController.setPrimaryStage(primaryStage);
        mainController.testNetwork();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }
}
