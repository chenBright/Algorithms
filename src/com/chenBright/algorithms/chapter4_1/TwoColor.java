package com.chenBright.algorithms.chapter4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

// 二分图（双色问题）
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            }
            else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

    public static void main() {
        Graph G = new Graph(new In("./data/tinyCG.txt"));
        TwoColor color = new TwoColor(G);
        StdOut.println(color.isBipartite());
    }
}
