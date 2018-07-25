package com.codecool.pionierzy.citytrafficsim.model.city;

import java.util.HashSet;

public class NetworkNode {
    private HashSet<NetworkNode> neighbours;
    public int x;
    public int y;

    public NetworkNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
