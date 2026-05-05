package org.example.visitorpattern;

public interface Visitor {
    long getResult();
    void visitNode(TreeNode node);
    void visitLeaf(TreeLeaf leaf);
}
