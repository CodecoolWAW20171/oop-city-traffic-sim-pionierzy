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
        NetworkNode startNode = new NetworkNode(-50, 350);

        NetworkNode c1r1 = new NetworkNode(50, 50);
        NetworkNode c1r2 = new NetworkNode(50, 350);
        NetworkNode c1r3 = new NetworkNode(50, 650);
        NetworkNode c2r1 = new NetworkNode(550, 650);
        NetworkNode c2r2 = new NetworkNode(550, 350);
        NetworkNode c2r3 = new NetworkNode(550, 50);
        NetworkNode c3r1 = new NetworkNode(1050, 650);
        NetworkNode c3r2 = new NetworkNode(1050, 350);
        NetworkNode c3r3 = new NetworkNode(1050, 50);


        new NetworkNodeDisplay(startNode, networkDisplay);

        new NetworkNodeDisplay(c1r1, networkDisplay);
        new NetworkNodeDisplay(c1r2, networkDisplay);
        new NetworkNodeDisplay(c1r3, networkDisplay);
        new NetworkNodeDisplay(c2r1, networkDisplay);
        new NetworkNodeDisplay(c2r2, networkDisplay);
        new NetworkNodeDisplay(c2r3, networkDisplay);
        new NetworkNodeDisplay(c3r1, networkDisplay);
        new NetworkNodeDisplay(c3r2, networkDisplay);
        new NetworkNodeDisplay(c3r3, networkDisplay);


        roads.add(c1r1.addNeighbour(c1r2));
        roads.add(c1r1.addNeighbour(c2r3));
        roads.add(c1r2.addNeighbour(c1r1));
        roads.add(c1r2.addNeighbour(c1r3));
        roads.add(c1r2.addNeighbour(startNode));
        roads.add(c1r3.addNeighbour(c2r1));
        roads.add(c1r3.addNeighbour(c1r2));
        roads.add(c2r3.addNeighbour(c1r1));
        roads.add(c2r1.addNeighbour(c1r3));
        roads.add(c2r1.addNeighbour(c2r3));
        roads.add(c2r3.addNeighbour(c2r1));
        roads.add(c1r2.addNeighbour(c2r2));
        roads.add(c2r2.addNeighbour(c1r2));
        roads.add(c2r1.addNeighbour(c2r2));
        roads.add(c2r3.addNeighbour(c2r2));
        roads.add(c2r2.addNeighbour(c2r1));
        roads.add(c2r2.addNeighbour(c2r3));

        roads.add(c2r1.addNeighbour(c3r1));
        roads.add(c3r1.addNeighbour(c2r1));
        roads.add(c2r2.addNeighbour(c3r2));
        roads.add(c3r2.addNeighbour(c2r2));
        roads.add(c2r3.addNeighbour(c3r3));
        roads.add(c3r3.addNeighbour(c2r3));
        roads.add(c3r1.addNeighbour(c3r2));
        roads.add(c3r2.addNeighbour(c3r1));
        roads.add(c3r2.addNeighbour(c3r3));
        roads.add(c3r3.addNeighbour(c3r2));













        roads.add(startNode.addNeighbour(c1r2));// leave it as a last road!


        for (Edge road : this.roads) {
            networkDisplay.createLaneView(road);
        }


        SimLoop simLoop = new SimLoop(networkDisplay);
        simLoop.start();
        VehicleGenerator generator = new VehicleGenerator(simLoop);
        generator.addToStartEdges(roads.get(roads.size() - 1)); //simple one edge

        new Thread(generator).start();

        Lights lTest = new Lights(c1r1, 10, LightsStatus.RED);
        LightsController lc = new LightsController();
        lc.getLightsArrayList().add(lTest);

        lc.startScheduledExecutorService();


    }
}
