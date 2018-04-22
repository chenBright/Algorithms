package com.chenBright.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/**
 * Created by chenbright on 2018/4/22.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && less(a[j + 1], a [j]); j--) {
                    exch(a, j + 1, j);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Exercise 2.1.18
     *
     * @param a
     */
    public static void drawSort(Comparable[] a) {
        int N = a.length;
        StdDraw.setYscale(N + 3, 0);
        StdDraw.setXscale(0, N + 3);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(3 + N / 2, 0.4, "a[ ]");
        StdDraw.text(1, 1, "i");
        StdDraw.text(2, 1, "j");
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, 1, i + "");
            StdDraw.text(3 + i, 2, a[i].toString());
        }
        StdDraw.line(0, 1.5, N + 3, 1.5);
        for (int i = 1; i < N; i++) {
            StdDraw.text(1, 2 + i, i + "");
            int red = i;
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                red = j - 1;
                StdDraw.text(3 + j, 2 + i, a[j].toString());
            }
            StdDraw.text(2, 2 + i, red + "");
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(3 + red, 2 + i, a[red].toString());
            StdDraw.setPenColor(Color.GRAY);
            for (int k = 0; k < N; k++) {
                if (k < red || k > i) {
                    StdDraw.text(3 + k, 2 + i, a[k].toString());
                }
            }
            StdDraw.setPenColor(Color.BLACK);
        }
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, N + 2, a[i].toString());
        }
    }

    public static void main() {
        Integer[] a = {9, 4, 2, 8, 7, 1};
//        String[] a = StdIn.readAllStrings();
//        sort(a);
        drawSort(a);
        assert isSorted(a);
        show(a);
    }
}
