package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_30 {
    public static int euclid(int p, int q) {
        if (p == 0 || q == 0) {
            return 1;
        }
        if (p < q) {
            int t = p;
            p = q;
            q = t;
        }
        if (p % q == 0) {
            return q;
        } else {
            return euclid(q, p % q);
        }
    }

    public static void main() {
        int N = StdIn.readInt();
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = euclid(i, j) == 1;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
