package com.codecool.pionierzy.citytrafficsim.model.city;

import com.codecool.pionierzy.citytrafficsim.view.city.NetworkNodeDisplay;

import java.util.ArrayList;
import java.util.HashMap;

public class NetworkNode {
    private ArrayList<NetworkNode> neighbours = new ArrayList<NetworkNode>();
    private int x;
    private int y;
    private HashMap<NetworkNode, Edge> roads = new HashMap<NetworkNode, Edge>();
    private NetworkNodeDisplay display;

    public NetworkNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<NetworkNode> getNeighbours() {
        return neighbours;
    }

    public Edge addNeighbour(NetworkNode node) {
        neighbours.add(node);
        Edge edge = new Edge(this, node);
        roads.put(node, edge);
        return edge;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public HashMap<NetworkNode, Edge> getRoads() {
        return roads;
    }
}
