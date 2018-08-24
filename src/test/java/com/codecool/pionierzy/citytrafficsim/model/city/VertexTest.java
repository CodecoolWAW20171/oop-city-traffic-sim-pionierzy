package com.codecool.pionierzy.citytrafficsim.model.city;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Basic Vertex tests")
class VertexTest {

    @Test
    @DisplayName("Vertex number test")
    void vertexNumberTest() {
        assertEquals(4, new Vertex(4).v());
    }

    @Test
    @DisplayName("HashCode test")
    void hasCodeTest() {
        assertEquals(2, new Vertex(2).hashCode());
    }

    @Test
    @DisplayName("HashCode is replicable for same objects")
    void hashCodeEqualsForSameObjects() {
        assertEquals(new Vertex(2).hashCode(), new Vertex(2).hashCode());
    }

    @Test
    @DisplayName("Same objects are equal")
    void equalsTest() {
        assertEquals(new Vertex(1), new Vertex(1));
    }


    @Test
    @DisplayName("Distance between vertices test")
    void distanceToTest() {
        Vertex v = new Vertex(1, 4.0, 1.0);
        Vertex w = new Vertex(2, 8.0, 4.0);
        assertEquals(5.0, v.distanceTo(w));
    }

    @Test
    @DisplayName("Coordinate getters test (x, y)")
    void gettersTest() {
        double x = 45.9;
        double y = 24.3;
        Vertex v = new Vertex(2, x, y);
        assertEquals(x, v.getX());
        assertEquals(y, v.getY());
    }
}