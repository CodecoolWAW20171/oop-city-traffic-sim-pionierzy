package com.codecool.pionierzy.citytrafficsim.model.city;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void equalsTest() {
        Vertex v = new Vertex(0);
        Vertex w = new Vertex(1);
        assertEquals(new Edge(v, w), new Edge(v, w));
    }
}