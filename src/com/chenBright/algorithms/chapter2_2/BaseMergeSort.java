package com.chenBright.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/24.
 * 排序模板
 */
public class BaseMergeSort {
    protected static Comparable[] aux;

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            // 左边取完
            if (i > mid) {
                a[k] = aux[j++];
            }
            // 右边取完
            else if (j > high) {
                a[k] = aux[i++];
            }
            // 取小的
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
