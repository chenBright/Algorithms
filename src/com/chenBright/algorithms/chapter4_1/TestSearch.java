package com.chenBright.algorithms.chapter4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {
    public static void main() {
        String[] files = {"./data/tinyG.txt", "./data/mediumG.txt", "./data/largeG.txt"};
        Graph G = new Graph(new In(files[0]));
        StdOut.print("输入结点（整数）：");
        int s = StdIn.readInt();
        DepthFirstSearch search = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();

        if (search.count() != G.V()) {
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
    }
}
