package com.codecool.pionierzy.citytrafficsim.model.city;

import java.util.*;

public class CityNetwork {
    private final int V;    // number of vertices
    private int E;          // number of edges
    private List<List<Edge>> adj;   // adjacency list
    private Vertex[] vertices;

    public CityNetwork(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V);
        for (int v = 0; v < V; v++) {
            adj.add(v, new LinkedList<>());
        }
        vertices = new Vertex[V];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(Edge e) {
        adj.get(e.from().v()).add(e);
        E++;
    }

    public Iterable<Edge> getEdgesFrom(int v) {
        return adj.get(v);
    }

    public Iterable<Edge> getAllEdges() {
        List<Edge> edges = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            edges.addAll(adj.get(v));
        }
        return edges;
    }

    public Vertex getVertex(int v) {
        return vertices[v];
    }

    public void addVertex(Vertex vertex) {
        int v = vertex.v();
        vertices[v] = vertex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices ").append(E).append(" edges\n");
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (Edge e : adj.get(v)) {
                sb.append(String.format("%d (%.2f), ", e.to().v(), e.getLength()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
