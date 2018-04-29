package com.chenBright.algorithms.chapter2_2;

/**
 * Created by chenbright on 2018/4/29.
 */
public class Ex2_2_19 extends BaseMergeSort {
    private static int merge(Comparable[] a, int low, int mid, int high, int inversions) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > high) {
                a[k] = aux[i++];
                inversions += j - k - 1;
            }
            else {
                a[k] = aux[i++];
            }
        }
        return inversions;
    }

    public static int count(Comparable[] a) {
        aux = new Comparable[a.length];
        return count(a, 0, a.length - 1, 0);
    }

    private static int count(Comparable[] a, int lo, int hi, int inversions) {
        if (hi <= lo) {
            return inversions;
        }
        int mid = lo + (hi - lo) / 2;
        inversions = count(a, lo, mid, inversions);
        inversions = count(a, mid + 1, hi, inversions);
        return merge(a, lo, mid, hi, inversions);
    }
}
