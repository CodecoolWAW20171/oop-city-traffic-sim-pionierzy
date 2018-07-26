package com.codecool.pionierzy.citytrafficsim.model.city;

import java.util.HashMap;
import java.util.HashSet;

public class NetworkNode {
    private HashSet<NetworkNode> neighbours;
    private int x;
    private int y;
    private HashMap<NetworkNode, Edge> roads;

    public NetworkNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public HashSet<NetworkNode> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(NetworkNode node) {
        neighbours.add(node);
        roads.put(node, new Edge(this, node));
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public HashMap<NetworkNode, Edge> getRoads() {
        return roads;
    }
}
