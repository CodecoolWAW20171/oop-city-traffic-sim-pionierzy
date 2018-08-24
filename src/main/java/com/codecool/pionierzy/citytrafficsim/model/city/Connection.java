package com.codecool.pionierzy.citytrafficsim.model.city;

import java.util.LinkedList;
import java.util.Objects;

public class Connection {
    private final int v;
    private final int w;
    private LinkedList<Edge> edges;


    public Connection(Edge edge) {
        this.v = edge.from().v();
        this.w = edge.to().v();
        this.edges = new LinkedList<>();
        edges.add(edge);
    }

    public void addEdge(Edge edge) {
        Edge initialEdge = edges.getFirst();
        if (edge.equals(initialEdge)) {
            edges.addFirst(edge);
        } else if (edge.equals(initialEdge.reversed())) {
            edges.addLast(edge);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Connection)) return false;
        Connection other = (Connection) obj;
        return edges.getFirst().isSameConnection(other.edges.getFirst());
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, w);
    }

    @Override
    public String toString() {
        return v + " <-> " + w;
    }
}
