package org.example.visitorpattern;

public class TreeNode extends NoteAbstract {
    TreeNode(int value, Color color, int nodeNumber) {
        this.value = value;
        this.color = color;
        this.nodeNumber = nodeNumber;
    }

    public TreeNode(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitNode(this);
        for (Node node : getNeighbours()) {
            node.accept(visitor);
        }
    }
}
