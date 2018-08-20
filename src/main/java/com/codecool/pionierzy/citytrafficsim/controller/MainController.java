package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Vehicle;
import com.codecool.pionierzy.citytrafficsim.view.city.Lane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainController {
    private Stage primaryStage;
    private ArrayList<Edge> roads = new ArrayList<Edge>();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startNewSimulation(Pane networkDisplay) {
        // this is here for tests, when network controller is done this will be obsolete
        NetworkNode node1 = new NetworkNode(150, 150);
        NetworkNode node2 = new NetworkNode(150, 500);
        NetworkNode node3 = new NetworkNode(500, 500);
        NetworkNode node4 = new NetworkNode(500, 150);
        roads.add(node1.addNeighbour(node2, networkDisplay));
        roads.add(node1.addNeighbour(node4, networkDisplay));
        roads.add(node2.addNeighbour(node1, networkDisplay));
        roads.add(node2.addNeighbour(node3, networkDisplay));
        roads.add(node3.addNeighbour(node4, networkDisplay));
        roads.add(node3.addNeighbour(node2, networkDisplay));
        roads.add(node4.addNeighbour(node1, networkDisplay));
        roads.add(node4.addNeighbour(node3, networkDisplay));
        node1.createVisualDisplay(networkDisplay);
        node2.createVisualDisplay(networkDisplay);
        node3.createVisualDisplay(networkDisplay);
        node4.createVisualDisplay(networkDisplay);

        SimLoop simLoop = new SimLoop();
        simLoop.start();
        VehicleGenerator generator = new VehicleGenerator(simLoop);
        generator.addToStartEdges(roads.get(0)); //simple one edge
        new Thread(generator).start();
    }
}
