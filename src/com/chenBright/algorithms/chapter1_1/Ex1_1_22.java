package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_22 {
    public static int rank (int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lower, int high, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.printf("  ");
        }
        StdOut.println("lo=" + lower + ", hi=" + high);
        if (lower > high) {
            return -1;
        }
        int mid = lower + (high - lower) / 2;
        if (key < a[mid]) {
            return rank(key, a, lower, high - 1, depth + 1);
        }
        else if (key > a[mid]) {
            return rank(key, a, lower + 1, high, depth + 1);
        }
        else {
            return mid;
        }
    }
    public static void main() {
        int[] a = { 1, 2, 3, 4, 6, 7, 8, 9, 12 };
        int key = 5;
        StdOut.println("1.1.22：");
        int pos = rank(key, a);
        if (pos == -1) {
            StdOut.println("not found!");
        } else {
            StdOut.println("position=" + pos);
        }
    }
}
