package org.example.visitorpattern;

public class ProductRedNodesVisitor implements Visitor {
    private long sumRedNodes = 1;
    private final long module = 1_000_000_007L;

    public long getResult() {
        return sumRedNodes;
    }

    @Override
    public void visitNode(TreeNode node) {
        if(node.getColor() == Color.Red) {
            sumRedNodes = (node.getValue() * sumRedNodes) % module;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.Red) {
            sumRedNodes = (leaf.getValue()  * sumRedNodes) % module;
        }
    }
}
