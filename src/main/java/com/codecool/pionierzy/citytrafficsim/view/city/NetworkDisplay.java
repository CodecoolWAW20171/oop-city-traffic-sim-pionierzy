package com.codecool.pionierzy.citytrafficsim.view.city;

import com.codecool.pionierzy.citytrafficsim.model.city.CityNetwork;
import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NetworkDisplay extends Pane {
    private CityNetwork network;
    private NodeDisplay[] nodes;
    private List<Lane> lanes;

    private HashMap<String, Image> images = new HashMap<>();

    public NetworkDisplay(CityNetwork network) {
        this.network = network;
        nodes = new NodeDisplay[network.getV()];
        lanes = new LinkedList<>();
    }

    public void createDisplay() {
        int V = network.getV();
        for (int v = 0; v < V; v++) {
            Vertex vertex = network.getVertex(v);
            NodeDisplay node = new NodeDisplay(vertex);
            nodes[v] = node;
            this.getChildren().add(node);
        }
        Iterable<Edge> edges = network.getAllEdges();
        for (Edge edge : edges) {
            Lane lane = new Lane(edge);
            lanes.add(lane);
            this.getChildren().add(lane);
        }
    }
}
