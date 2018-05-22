package com.chenBright.algorithms.chapter4_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DegreesOfSeparationDFS {
    public static void main() {
        SymbolGraph sg = new SymbolGraph("./data/movies.txt","/");

        Graph G = sg.G();

        StdOut.print("Source: ");
        String source = StdIn.readLine();
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        DepthFirstPaths dfp = new DepthFirstPaths(G, s);

        StdOut.print("Query:  ");
        String query = StdIn.readLine();
        if (sg.contains(query)) {
            int t = sg.index(query);
            if (dfp.hasPathTo(t)) {
                for (int v : dfp.pathTo(t)) {
                    StdOut.println("   " + sg.name(v));
                }
            } else {
                StdOut.println("Not connected");
            }
        } else {
            StdOut.println("Not in database.");
        }
    }
}
