package com.chenBright.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by chenbright on 2018/4/21.
 */
public class QuickUnionPathCompressionUF extends QuickUnionUF {
    public QuickUnionPathCompressionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        int root = id[p];
        while (id[root] != root) {
            root = id[root];
        }
        while (id[p] != root) {
            int newP = id[p];
            id[p] = root;
            p = newP;
        }
        return root;
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
        QuickUnionPathCompressionUF quickUnionPathCompressionUF = new QuickUnionPathCompressionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickUnionPathCompressionUF.connected(p, q)) {
                continue;
            }
            quickUnionPathCompressionUF.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickUnionPathCompressionUF.count() + " 个连通分量");
    }
}
