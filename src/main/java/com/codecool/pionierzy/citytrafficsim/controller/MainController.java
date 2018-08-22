package com.codecool.pionierzy.citytrafficsim.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {
    public static final String FXML = "/fxml/main_controls.fxml";

    private Stage primaryStage;
    private NetworkController networkController;

    @FXML
    Pane networkContainer;

    @FXML
    Button startBtn;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void testNetwork() {
        networkController = new NetworkController();
        networkController.loadSampleNetwork(networkContainer);
    }

    public void startNewSimulation(Pane networkDisplay) {
        // this is here for tests, when network controller is done this will be obsolete


        SimLoop simLoop = new SimLoop();
        simLoop.start();
        VehicleGenerator generator = new VehicleGenerator(simLoop);
//        generator.addToStartEdges(roads.get(0)); //simple one edge


//        new Thread(generator).start();
    }
}
