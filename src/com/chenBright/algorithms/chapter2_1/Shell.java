package com.chenBright.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/23.
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int shellLength = len / 2; shellLength > 0; shellLength /= 2) {
            for (int i = shellLength; i < len; i++) {
                for (int j = i; j >= shellLength && less(a[j], a[j - shellLength]); j -= shellLength) {
                        exch(a, j, j - shellLength);
                }
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

    public static void main() {
        Integer[] a = {9, 4, 2, 8, 7, 1};
//        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
