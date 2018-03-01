package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_15 {
    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0 && a[i] < M) {
                result[a[i]]++;
            }
        }
        return result;
    }

    public static void main() {
        int[] a = { 1, 1, 2, 3, 1, 7, 5, 3, 2, 2, 2 };
        int[] result = histogram(a, 8);
        for (int i = 0; i < result.length; i++) {
            StdOut.printf("%3d", result[i]);
        }
    }
}
