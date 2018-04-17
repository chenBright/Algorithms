package com.chenBright.algorithms.chapter1_1;

/**
 * Created by chenbright on 2018/4/16.
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (key < a[mid]) {
            return rank(key, a, low, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, high);
        } else {
            return mid;
        }
    }
}
