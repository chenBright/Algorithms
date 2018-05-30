package com.chenBright.algorithms.chapter4_3;

import edu.princeton.cs.algs4.*;

public class Ex22KruskalMST {
    private Queue<Edge> mst;

    public Ex22KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());

        Graph graph = new Graph(G.V());
        for (Edge e : G.edges()) {
            int v = e.either();
            int w = e.other(v);
            graph.addEdge(v, w);
        }

        CC c = new CC(graph);

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
