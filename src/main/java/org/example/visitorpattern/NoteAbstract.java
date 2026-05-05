package org.example.visitorpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class NoteAbstract implements Node {
    protected int depth = 0;
    protected int value = 0;
    protected Color color = null;
    protected int nodeNumber = 0;
    protected List<Node> neighbours = new ArrayList<>();

    @Override
    public void setNodeNumber(int nodeNumber){
        this.nodeNumber = nodeNumber;
    }

    @Override
    public int getNodeNumber(){
        return nodeNumber;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<Node> getNeighbours(){
        return neighbours;
    }

    public void addNeighbour(Node node){
        neighbours.add(node);
    }
}
