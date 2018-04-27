package com.chenBright.algorithms.chapter2_2;

import com.chenBright.algorithms.chapter2_1.BaseSort;

import static com.chenBright.algorithms.chapter2_2.BaseMergeSort.aux;

/**
 * Created by chenbright on 2018/4/26.
 */
public class Ex2_2_10 extends BaseSort {
    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = high;
        for (int k = low; k <= mid; k++) {
            aux[k] = a[k];
        }
        for (int k = mid + 1; k <= high; k++) {
            aux[k] = a[high + mid + 1 - k];
        }
        for (int k = low; k <= high; k++) {
            if (less(aux[j], aux[i])) {
                a[k] = aux[j--];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }
}
