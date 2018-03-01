package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_13 {
    public static void printTransposedMatrix(int[][] matrix) {
        StdOut.println(matrix[0].length);
        StdOut.println(matrix.length);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                StdOut.printf("%4d", matrix[j][i]);
            }
            StdOut.println();
        }
    }
    public static void main() {
        StdOut.println("1.1.13：");
        int[][] a = { { 100, 200, 300 }, { 400, 500, 600 } };
        printTransposedMatrix(a);
    }
}
