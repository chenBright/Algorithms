package com.chenBright.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/**
 * Created by chenbright on 2018/4/22.
 */
public class Selection {
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void show(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }

    private static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
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
        StdDraw.setYscale(N + 4, 0);
        StdDraw.setXscale(0, N + 3);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(3 + N / 2, 0.4, "a[ ]");
        StdDraw.textRight(1, 1, "i");
        StdDraw.textRight(2, 1, "min");
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, 1, i + "");
            StdDraw.text(3 + i, 2, a[i].toString());
        }
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            StdDraw.textRight(1, 3 + i, i + "");
            StdDraw.textRight(2, 3 + i, min + "");
            StdDraw.setPenColor(Color.GRAY);
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    StdDraw.setPenColor(Color.BLACK);
                }
                if (j == min) {
                    StdDraw.setPenColor(Color.RED);
                }
                StdDraw.text(3 + j, 3 + i, a[j].toString());
                if (j == min) {
                    StdDraw.setPenColor(Color.BLACK);
                }
            }
            exch(a, i, min);
        }
        for (int i = 0; i < N; i++) {
            StdDraw.text(3 + i, N + 3, a[i].toString());
        }
    }

    public static void main() {
//        Integer[] a = {9, 4, 2, 8, 7, 1};
        String[] a = StdIn.readAllStrings();
//        sort(a);
        drawSort(a);
        assert isSorted(a);
        show(a);
    }
}
