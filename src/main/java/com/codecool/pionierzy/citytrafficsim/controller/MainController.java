package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.model.lights.Lights;
import com.codecool.pionierzy.citytrafficsim.model.lights.LightsStatus;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkNodeDisplay;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainController {
    private Stage primaryStage;
    private ArrayList<Edge> roads = new ArrayList<Edge>();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startNewSimulation(NetworkDisplay networkDisplay) {
        // this is here for tests, when network controller is done this will be obsolete
        NetworkNode nw = new NetworkNode(350, 150);
        NetworkNode w = new NetworkNode(350, 325);
        NetworkNode sw = new NetworkNode(350, 500);
        NetworkNode se = new NetworkNode(700, 500);
        NetworkNode ne = new NetworkNode(700, 150);
        NetworkNode startNode = new NetworkNode(100, 325);


        NetworkNodeDisplay node1Display = new NetworkNodeDisplay(nw, networkDisplay);
        NetworkNodeDisplay node2Display = new NetworkNodeDisplay(w, networkDisplay);
        NetworkNodeDisplay node3Display = new NetworkNodeDisplay(sw, networkDisplay);
        NetworkNodeDisplay node4Display = new NetworkNodeDisplay(se, networkDisplay);
        NetworkNodeDisplay node5Display = new NetworkNodeDisplay(ne, networkDisplay);
        NetworkNodeDisplay startNodeDisplay = new NetworkNodeDisplay(startNode, networkDisplay);


        roads.add(nw.addNeighbour(w)); //1
        roads.add(nw.addNeighbour(ne)); //2
        roads.add(w.addNeighbour(nw)); //3
        roads.add(w.addNeighbour(sw)); //4
        roads.add(w.addNeighbour(startNode)); //5
        roads.add(sw.addNeighbour(se)); //6
        roads.add(sw.addNeighbour(w)); //7
        roads.add(ne.addNeighbour(nw)); //8
        roads.add(se.addNeighbour(sw)); //9
        roads.add(se.addNeighbour(ne)); //10
        roads.add(ne.addNeighbour(se)); //11

        roads.add(startNode.addNeighbour(w));// leave it as a last road! //12


        for (Edge road : this.roads) {
            networkDisplay.createLaneView(road);
        }


        SimLoop simLoop = new SimLoop(networkDisplay);
        VehicleGenerator generator = new VehicleGenerator(simLoop);
        generator.addToStartEdges(roads.get(roads.size() - 1)); //simple one edge
        Thread vehicleGenerator = new Thread(generator);
        Lights left = new Lights(roads.get(11), 10, LightsStatus.RED);
        Lights down = new Lights(roads.get(6), 10, LightsStatus.GREEN);
        Lights up = new Lights(roads.get(0), 10, LightsStatus.GREEN);
        LightsController lightsController = new LightsController();
        lightsController.getLightsArrayList().add(left);
        lightsController.getLightsArrayList().add(down);
        lightsController.getLightsArrayList().add(up);

        simLoop.start();
        vehicleGenerator.start();
        lightsController.startScheduledExecutorService();


    }
}
