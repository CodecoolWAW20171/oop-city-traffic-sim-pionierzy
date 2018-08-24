package com.codecool.pionierzy.citytrafficsim.model.city;

public class Vertex {
    private final int v;
    private final double x;
    private final double y;

    public Vertex(int v) {
        this(v, 0, 0);
    }

    public Vertex(int v, double x, double y) {
        this.v = v;
        this.x = x;
        this.y = y;
    }

    public int v() {
        return v;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Vertex other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Vertex)) return false;
        Vertex other = (Vertex) obj;
        return this.v == other.v;
    }

    @Override
    public int hashCode() {
        return v;
    }

    @Override
    public String toString() {
        return String.format("%d (%.2f, %.2f)", v, x, y);
    }
}
