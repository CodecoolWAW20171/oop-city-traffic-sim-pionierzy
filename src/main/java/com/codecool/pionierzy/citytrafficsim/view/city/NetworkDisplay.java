package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.CityNetwork;
import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.*;

public class NetworkDisplay extends Pane {
    private CityNetwork network;
    private NodeDisplay[] nodes;
    private List<Road> roads;

    private HashMap<String, Image> images;

    public NetworkDisplay(CityNetwork network) {
        this.network = network;
        nodes = new NodeDisplay[network.getV()];
        roads = new LinkedList<>();
    }

    public void createDisplay() {
        int V = network.getV();
        for (int v = 0; v < V; v++) {
            Vertex vertex = network.getVertex(v);
            NodeDisplay node = new NodeDisplay(vertex.getX(), vertex.getY());
            nodes[v] = node;
            this.getChildren().add(node.getShape());
        }

    }
}
