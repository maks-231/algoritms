package org.example.visitorpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// DFS (Depth-first search)/Поиск в глубину
// https://faangmaster.medium.com/dfs-depth-first-search-%D0%BF%D0%BE%D0%B8%D1%81%D0%BA-%D0%B2-%D0%B3%D0%BB%D1%83%D0%B1%D0%B8%D0%BD%D1%83-43582683376c

// Поиск в ширину (Breadth-first Search)
// https://faangmaster.medium.com/%D0%BF%D0%BE%D0%B8%D1%81%D0%BA-%D0%B2-%D1%88%D0%B8%D1%80%D0%B8%D0%BD%D1%83-breadth-first-search-b5c903f31c49

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Visitor sumInLeavesVisitor = new SumInLeavesVisitor();
        Visitor productRedNodesVisitor = new ProductRedNodesVisitor();
        Visitor fancyVisitor = new FancyVisitor();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество узлов: ");
        int n = in.nextInt();
        int[] values = new int[n];
        int[] colors = new int[n];

        Edge[] edges = new Edge[n];

        in.reset();
        System.out.println("Введите числа: ");
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }

        in.reset();
        System.out.println("Введите цвет 0 = Red, 1 = Green: ");
        for (int i = 0; i < n; i++) {
            colors[i] = in.nextInt();
        }

        in.reset();
        System.out.println("Введите грани: ");
        for (int i = 0; i < n - 1 ; i++) {
            edges[i] = new Edge(in.nextInt(), in.nextInt());
        }

        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(values[i], colors[i] == 0 ? Color.Red :  Color.Green);
            node.setNodeNumber(i + 1);
            nodes.add(node);
        }

        tree.buildTreeByEdges(nodes, edges, n);

        tree.accept(sumInLeavesVisitor);
        tree.accept(productRedNodesVisitor);
        tree.accept(fancyVisitor);

        System.out.println("sumInLeavesVisitor.getResult() = " + sumInLeavesVisitor.getResult());
        System.out.println("productRedNodesVisitor.getResult() = " + productRedNodesVisitor.getResult());
        System.out.println("fancyVisitor.getResult() = " + fancyVisitor.getResult());
        in.close();

        System.out.println("Exit");
    }
}
