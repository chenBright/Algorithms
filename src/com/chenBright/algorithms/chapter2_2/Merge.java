package com.chenBright.algorithms.chapter2_2;

/**
 * Created by chenbright on 2018/4/25.
 * 自顶向下归并
 */
public class Merge extends BaseMergeSort {
    public static void sort(Comparable[] a) {
        int len = a.length;
        aux = new Comparable[len];
        sort(a, 0, len - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = (low + high) / 2;
        sort(a, low, mid); // 左半边排序
        sort(a, mid + 1, high); // 右半边排序
        merge(a, low, mid, high); // 归并
    }

    public static void main() {
        Integer[] a = {9, 4, 2, 8, 7, 1};
//        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
