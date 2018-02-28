package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/2/28.
 */
public class Ex1_1_11 {
    public static void main() {
        boolean[][] matrix = { { true, false, true }, { false, true, false }, { true, true, false } };
        printBooleanMatrix(matrix);
    }
    public static void printBooleanMatrix(boolean[][] matrix) {
        System.out.print(' ');
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] ? '*' : ' ');
            }
            System.out.println();
        }
    }
}
