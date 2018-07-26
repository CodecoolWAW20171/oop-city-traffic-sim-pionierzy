package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startNewSimulation(Pane networkDisplay) {
        // this is here for tests, when network controller is done this will be obsolete
        NetworkNode node1 = new NetworkNode(150, 150);
        NetworkNode node2 = new NetworkNode(150, 500);
        NetworkNode node3 = new NetworkNode(500, 500);
        NetworkNode node4 = new NetworkNode(500, 150);
        node1.addNeighbour(node2,networkDisplay);
        node1.addNeighbour(node4,networkDisplay);
        node2.addNeighbour(node1,networkDisplay);
        node2.addNeighbour(node3,networkDisplay);
        node3.addNeighbour(node4,networkDisplay);
        node3.addNeighbour(node2,networkDisplay);
        node4.addNeighbour(node1,networkDisplay);
        node4.addNeighbour(node3,networkDisplay);
        node1.createVisualDisplay(networkDisplay);
        node2.createVisualDisplay(networkDisplay);
        node3.createVisualDisplay(networkDisplay);
        node4.createVisualDisplay(networkDisplay);

    }
}
