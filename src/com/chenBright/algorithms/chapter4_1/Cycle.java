package com.chenBright.algorithms.chapter4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 是否为无环图（假设不存在自环或平行边）
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            }
            /**
             * u为v前一个顶点，v为w前一个顶点，三个顶点在同一路径
             * 但w已经被访问过，现在又遍历到了，所以必然存在环
             * 因为u、v依附同一条边，所以v可以遍历到u，且假设不存在平行边 >>>> w != u
             */
            else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main() {
        Graph G = new Graph(new In("./data/tinyCG.txt"));
        Cycle cycle = new Cycle(G);
        StdOut.println("has cycle: " + cycle.hasCycle());
    }
}
