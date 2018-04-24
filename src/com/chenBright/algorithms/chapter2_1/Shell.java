package com.chenBright.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/23.
 */
public class Shell extends BaseSort {
    public static void sort(Comparable[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        for (; h > 0; h /= 3) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                        exch(a, j, j - h);
                }
            }
        }
    }

    public static void main() {
        Integer[] a = {9, 4, 2, 8, 7, 1};
//        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
