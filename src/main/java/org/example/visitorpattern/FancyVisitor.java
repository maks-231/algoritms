package org.example.visitorpattern;

public class FancyVisitor implements Visitor {
    private long sumEvenNodes;
    private long sumGreenLeaves;

    public FancyVisitor() {
        this.sumEvenNodes = 0;
        this.sumGreenLeaves = 0;
    }

    public long getResult() {
        return Math.abs(sumEvenNodes -  sumGreenLeaves);
    }

    @Override
    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0) {
            sumEvenNodes += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.Green) {
            sumGreenLeaves += leaf.getValue();
        }
    }
}
