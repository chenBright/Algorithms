package com.chenBright.algorithms.chapter5_1;

public class Insertion {
    public static void sort(String[] a, int low, int high, int d) {
        for (int i = low + 1; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
