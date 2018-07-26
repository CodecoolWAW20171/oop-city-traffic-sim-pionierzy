package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.view.city.NetworkNodeDisplay;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.HashSet;

public class NetworkNode {
    private HashSet<NetworkNode> neighbours = new HashSet<NetworkNode>();
    private int x;
    private int y;
    private HashMap<NetworkNode, Edge> roads = new HashMap<NetworkNode, Edge>();
    private NetworkNodeDisplay display;

    public NetworkNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void createVisualDisplay(Pane pane) {
        display = new NetworkNodeDisplay(this, pane);
    }

    public HashSet<NetworkNode> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(NetworkNode node) {
        neighbours.add(node);
        roads.put(node, new Edge(this, node));
    }

    public void addNeighbour(NetworkNode node, Pane pane) {
        neighbours.add(node);
        roads.put(node, new Edge(this, node, pane));
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public HashMap<NetworkNode, Edge> getRoads() {
        return roads;
    }
}
