package com.codecool.pionierzy.citytrafficsim.model.city;

public class Vertex {
    private final int v;
    private double x;
    private double y;

    public Vertex(int v, double x, double y) {
        this.v = v;
        this.x = x;
        this.y = y;
    }

    public int getV() {
        return v;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%d (%.2f, %.2f)", v, x, y);
    }
}