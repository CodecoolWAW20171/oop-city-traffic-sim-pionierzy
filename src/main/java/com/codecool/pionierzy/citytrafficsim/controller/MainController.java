package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startNewSimulation(Pane networkDisplay) {
        NetworkNode node1 = new NetworkNode(150, 150);
        NetworkNode node2 = new NetworkNode(150, 500);
        NetworkNode node3 = new NetworkNode(500, 500);
        NetworkNode node4 = new NetworkNode(500, 150);
        node1.addNeighbour(node2);
        node1.addNeighbour(node4);
        node2.addNeighbour(node1);
        node2.addNeighbour(node3);
        node3.addNeighbour(node4);
        node3.addNeighbour(node1);
        node4.addNeighbour(node1);
        node4.addNeighbour(node3);
        node1.createVisualDisplay(networkDisplay);
        node2.createVisualDisplay(networkDisplay);
        node3.createVisualDisplay(networkDisplay);
        node4.createVisualDisplay(networkDisplay);
    }
}
