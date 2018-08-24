package com.codecool.pionierzy.citytrafficsim.model.city;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {

    @Test
    void hashCodeTest() {
        Vertex v = new Vertex(0, 0.0, 0.0);
        Vertex w = new Vertex(1, 1.0, 1.0);
        Connection c1 = new Connection(new Edge(v, w));
        Connection c2 = new Connection(new Edge(w, v));
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}