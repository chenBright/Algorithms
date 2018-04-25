package com.chenBright.algorithms.chapter2_2;

/**
 * Created by chenbright on 2018/4/25.
 * 自底向上归并
 */
public class MergeBU extends BaseMergeSort {
    public static void sort(Comparable[] a) {
        int len = a.length;
        aux = new Comparable[len];

        for (int sz = 1; sz < len; sz *= 2) {
            for (int low = 0; low < len - sz; low += sz + sz) {
                merge(a, low, low + sz - 1, Math.min(low + sz + sz, len - 1));
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
