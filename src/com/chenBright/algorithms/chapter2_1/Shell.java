package com.chenBright.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/23.
 */
public class Shell extends BaseSort {
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

    public static void main() {
        Integer[] a = {9, 4, 2, 8, 7, 1};
//        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
