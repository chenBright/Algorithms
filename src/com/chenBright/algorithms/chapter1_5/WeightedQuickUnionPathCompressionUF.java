package com.chenBright.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by chenbright on 2018/4/21.
 */
public class WeightedQuickUnionPathCompressionUF extends WeightedQuickUnionUF{
    public WeightedQuickUnionPathCompressionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != id[root])
            root = id[root];
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public static void main() {
        String[] files = {"./data/tinyUF.txt", "mediumUF.txt", "./data/largeUF.txt"};
        try {
            FileInputStream input = new FileInputStream(files[2]);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int N = StdIn.readInt();
        WeightedQuickUnionPathCompressionUF weightedQuickUnionPathCompressionUF = new WeightedQuickUnionPathCompressionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (weightedQuickUnionPathCompressionUF.connected(p, q)) {
                continue;
            }
            weightedQuickUnionPathCompressionUF.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(weightedQuickUnionPathCompressionUF.count() + " 个连通分量");
    }
}
