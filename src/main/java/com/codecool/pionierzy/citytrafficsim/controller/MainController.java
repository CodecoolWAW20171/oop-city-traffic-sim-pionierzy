package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkNodeDisplay;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainController {
    private Stage primaryStage;
    private ArrayList<Edge> roads = new ArrayList<Edge>();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startNewSimulation(NetworkDisplay networkDisplay) {
        // this is here for tests, when network controller is done this will be obsolete
        NetworkNode node1 = new NetworkNode(150, 150);
        NetworkNode node2 = new NetworkNode(150, 500);
        NetworkNode node3 = new NetworkNode(500, 500);
        NetworkNode node4 = new NetworkNode(500, 150);
        NetworkNodeDisplay node1Display = new NetworkNodeDisplay(node1, networkDisplay);
        NetworkNodeDisplay node2Display = new NetworkNodeDisplay(node2, networkDisplay);
        NetworkNodeDisplay node3Display = new NetworkNodeDisplay(node3, networkDisplay);
        NetworkNodeDisplay node4Display = new NetworkNodeDisplay(node4, networkDisplay);


        roads.add(node1.addNeighbour(node2));
        roads.add(node1.addNeighbour(node4));
        roads.add(node2.addNeighbour(node1));
        roads.add(node2.addNeighbour(node3));
        roads.add(node3.addNeighbour(node4));
        roads.add(node3.addNeighbour(node2));
        roads.add(node4.addNeighbour(node1));
        roads.add(node4.addNeighbour(node3));

        for (Edge road : this.roads) {
            networkDisplay.createLaneView(road);
        }


        SimLoop simLoop = new SimLoop(networkDisplay);
        simLoop.start();
        VehicleGenerator generator = new VehicleGenerator(simLoop);
        generator.addToStartEdges(roads.get(3)); //simple one edge


//        new Thread(generator).start();
        generator.generateOneCar(roads.get(3));

    }
}
