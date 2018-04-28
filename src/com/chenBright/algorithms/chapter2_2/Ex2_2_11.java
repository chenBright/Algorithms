package com.chenBright.algorithms.chapter2_2;

import com.chenBright.algorithms.chapter2_1.Insertion;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/28.
 */
public class Ex2_2_11 {
    private static int CUTOFF = 15;

    public static void merge(Comparable[] src, Comparable[] dest, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                dest[k] = src[j++];
            } else if (j > high) {
                dest[k] = src[i++];
            } else if (less(src[j], src[i])) {
                dest[k] = src[j++];
            } else {
                dest[k] = src[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }

    private static void sort(Comparable[] src, Comparable[] dest, int low, int high) {
        if (high - low < CUTOFF) {
            insertionSort(dest, low, high);
            return;
        }
        int mid = (low + high) / 2;
        // 递归 归并 交换主数组和辅助数组的角色
        sort(dest, src, low, mid);
        sort(dest, src, mid + 1, high);

        if (less(dest[mid + 1], dest[mid])) {
            merge(src, dest, low, mid, high);
        }
    }

    private static void insertionSort(Comparable[] a, int low, int high) {
        for (int i = low; i < high - 1; i++) {
            for (int j = i + 1; j > low && less(a[j], a[j - 1]); j++) {
                exch(a, j, j - 1);
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
}
