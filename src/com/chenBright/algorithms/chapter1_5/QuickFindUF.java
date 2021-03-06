package com.chenBright.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by chenbright on 2018/4/19.
 */
public class QuickFindUF {
    private int[] id; // 分量id
    private int count; // 分量数量

    public QuickFindUF(int N) {
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
        return id[p];
    }

    /**
     * 连接p、q
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
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
        QuickFindUF quickFindUf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickFindUf.connected(p, q)) {
                continue;
            }
            quickFindUf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickFindUf.count() + " 个连通分量");
    }
}
