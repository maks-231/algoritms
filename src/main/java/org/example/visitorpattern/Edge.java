package org.example.visitorpattern;

public class Edge {
    private int src;
    private int dst;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }
}
