package org.example.visitorpattern;

public class TreeLeaf extends TreeNode {
    TreeLeaf(int value, Color color, int nodeNumber) {
        super(value, color, nodeNumber);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLeaf(this);
    }
}
