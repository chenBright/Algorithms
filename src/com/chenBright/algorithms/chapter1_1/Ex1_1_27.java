package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_27 {
    private static long COUNT = 0;
    private static long COUNT2 = 0;
    private static double[][] MATRIX;

    public static double binomial(int N, int k, double p) {
        COUNT++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    private static double bin(int N, int k, double p) {
        COUNT2++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        if (MATRIX[N][k] == -1) {
            MATRIX[N][k] = (1.0 - p) * bin(N - 1, k, p) + p * bin(N - 1, k - 1, p);
        }
        return MATRIX[N][k];
    }

    public static double betterBinomial(int N, int k, double p) {
        MATRIX = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                MATRIX[i][j] = -1;
            }
        }
        return bin(N, k, p);
    }

    public static void main() {
        StdOut.println("result: " + binomial(100, 50, 0.25) + ", count: " + COUNT);
        StdOut.println("result: " + betterBinomial(100, 50, 0.25) + ", count: " + COUNT2);
    }
}
