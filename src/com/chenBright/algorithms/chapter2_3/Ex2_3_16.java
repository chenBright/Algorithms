package com.chenBright.algorithms.chapter2_3;

/**
 * Created by chenbright on 2018/5/1.
 */
public class Ex2_3_16 {
    public static int[] best(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        best(a, 0, n-1);
        return a;
    }

    private static void best(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        best(a, low, mid);
        best(a, mid + 1, high);
        exch(a, low, mid);
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
