package com.chenBright.algorithms.chapter2_3;

/**
 * Created by chenbright on 2018/5/1.
 */
public class Ex2_3_5 extends BaseQuickSort {
    public static void sort(Comparable[] a) {
        int lt = 0, i = 0, gt = a.length - 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0) {
                exch(a, lt++, i);
            }
            else if (cmp > 0) {
                exch(a, i, gt--);
            }
            else {
                i++;
            }
        }
    }
}
