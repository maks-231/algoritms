package org.example.visitorpattern;

import java.util.List;

public interface Node {
    int getValue();
    Color getColor();
    int getDepth();
    void setDepth(int depth);
    void accept(Visitor visitor);
    void setNodeNumber(int nodeNumber);
    int getNodeNumber();
    List<Node> getNeighbours();
    void addNeighbour(Node node);
}
