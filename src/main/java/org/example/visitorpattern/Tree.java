package org.example.visitorpattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    private Node root;

    public void buildTreeByEdges(List<Node> nodes, Edge[] edges, int nodesNumber) {
        List<Integer>[] adj = new ArrayList[nodesNumber + 1];
        for (int i = 1; i <= nodesNumber; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < nodesNumber - 1; i++) {
            if (edges[i] != null) {
                adj[edges[i].getSrc()].add(edges[i].getDst());
                adj[edges[i].getDst()].add(edges[i].getSrc());
            }
        }

        root = nodes.get(0);
        root.setDepth(0);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean[] visited = new boolean[nodesNumber + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int u = current.getNodeNumber();

            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    Node node = nodes.get(v - 1);
                    node.setDepth(current.getDepth() + 1);
                    if (adj[v].size() == 1) {
                        TreeLeaf leaf = new TreeLeaf(node.getValue(), node.getColor(), node.getNodeNumber());
                        leaf.setDepth(current.getDepth() + 1);
                        current.addNeighbour(leaf);
                        queue.add(leaf);
                    } else {
                        node.setDepth(current.getDepth() + 1);
                        current.addNeighbour(node);
                        queue.add(node);
                    }
                }
            }
        }
    }

    void accept(Visitor visitor) {
        root.accept(visitor);
    }
}
