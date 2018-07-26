package com.codecool.pionierzy.citytrafficsim.model.city;

import java.util.HashSet;

public class NetworkNode {
    private HashSet<NetworkNode> neighbours;
    private int x;
    private int y;

    public NetworkNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public HashSet<NetworkNode> getNeighbours() {
        return neighbours;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
