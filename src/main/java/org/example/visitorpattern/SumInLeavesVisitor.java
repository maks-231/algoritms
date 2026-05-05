package org.example.visitorpattern;

public class SumInLeavesVisitor implements Visitor {
    private long sumLeaves;

    public SumInLeavesVisitor() {
        this.sumLeaves = 0;
    }

    public long getResult() {
        return sumLeaves;
    }

    @Override
    public void visitNode(TreeNode node) {
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sumLeaves += leaf.getValue();
    }
}
