package com.codecool.pionierzy.citytrafficsim.model.city;

import java.util.*;
import java.util.stream.Collectors;

public class CityNetwork {
    private final int V;    // number of vertices
    private int E;          // number of edges
    private List<List<Edge>> adj;   // adjacency list
    private Vertex[] vertices;
    // TODO: Connections collection
    private Set<Connection> connections;


    public CityNetwork(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V);
        for (int v = 0; v < V; v++) {
            adj.add(v, new LinkedList<>());
        }
        vertices = new Vertex[V];
        this.connections = new LinkedHashSet<>();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(Edge e) {
        adj.get(e.from().v()).add(e);
        if (!connections.add(new Connection(e))) {
            System.out.println("Exists");
        }
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

    public Iterable<Edge> getEdgesBetween(int v, int w) {
        List<Edge> edges = new LinkedList<>();
        edges.addAll(adj.get(v).stream().filter(e -> e.to().v() == w).collect(Collectors.toList()));
        edges.addAll(adj.get(w).stream().filter(e -> e.to().v() == v).collect(Collectors.toList()));
        return edges;
    }

    public Vertex getVertex(int v) {
        return vertices[v];
    }

    public void addVertex(Vertex vertex) {
        int v = vertex.v();
        vertices[v] = vertex;
    }

    public Set<Connection> getConnections() {
        return connections;
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
