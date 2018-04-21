package com.chenBright.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by chenbright on 2018/4/20.
 */
public class QuickUnionUF {
    protected int[] id; // 分量id
    protected int count; // 分量数量

    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 连通分量数量
     * @return 数量
     */
    public int count() {
        return count;
    }

    /**
     * p和q是否存在同一分量中
     * @param p
     * @param q
     * @return true / false
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p所在的分量的id
     * @param p
     * @return id
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 连接p、q
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;
    }

    public static void main() {
        String[] files = {"./data/tinyUF.txt", "mediumUF.txt", "./data/largeUF.txt"};
        try {
            FileInputStream input = new FileInputStream(files[1]);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int N = StdIn.readInt();
        QuickUnionUF quickUnionUF = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickUnionUF.connected(p, q)) {
                continue;
            }
            quickUnionUF.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickUnionUF.count() + " 个连通分量");
    }
}
