package com.chenBright.algorithms.chapter4_4;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CPM {
    public static void main() {
        try {
            FileInputStream input = new FileInputStream("./data/jobsPC.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int N = StdIn.readInt();
        StdIn.readLine();
        edu.princeton.cs.algs4.EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * N + 2);
        int s = 2 * N, t = 2 * N + 1;
        for (int i = 0; i < N; i++) {
            String[] a = StdIn.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i , i + N, duration));
            G.addEdge(new DirectedEdge(s, i, 0.0));

            G.addEdge(new DirectedEdge(i + N, t, 0.0));
            for (int j = 0; j < a.length; j++) {
                // 报错 Exception in thread "main" java.lang.NumberFormatException: For input string: "41.0"
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i + N, successor, 0.0));
            }
            AcyclicLP lp = new AcyclicLP(G, s);

            StdOut.println("Start times: ");
            for (int j = 0; j < N; j++) {
                StdOut.printf("%4d: %5.1f\n", i, lp.distTo(i));
            }
            StdOut.printf("Finish time: %5.1f\n", lp.distTo(t));
        }
    }
}
