package com.chenBright.algorithms.chapter2_1;

/**
 * Created by chenbright on 2018/4/24.
 */
public class Ex2_1_25 extends BaseSort {
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int min = i;
            for (int j = i - 1; j >= 0 && less(a[j + 1], a [j]); j--) {
                min = j;
            }
            if (min != i) {
                exch(a, i, min);
            }
        }
    }
}
