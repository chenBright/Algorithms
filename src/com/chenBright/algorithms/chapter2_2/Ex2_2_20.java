package com.chenBright.algorithms.chapter2_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/30.
 */
public class Ex2_2_20 extends BaseMergeSort {
    public static void merge(Comparable[] a, int[] index, int[] aux, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = index[k];
        }

        for (int k = low; k <= high; k++) {
            // 左边取完
            if (i > mid) {
                index[k] = aux[j++];
            }
            // 右边取完
            else if (j > high) {
                index[k] = aux[i++];
            }
            // 取小的
            else if (less(a[aux[j]], a[aux[i]])) {
                index[k] = aux[j++];
            }
            else {
                index[k] = aux[i++];
            }
        }
    }

    public static int[] indexSort(Comparable[] a) {
        int len = a.length;
        // 索引号数组
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        // 辅助数组，存储复制的索引号
        int[] aux = new int[len];
        sort(a, index, aux, 0, len - 1);
        return index;
    }

    private static void sort(Comparable[] a, int[] index, int[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, index, aux, low, mid);
        sort(a, index, aux, mid + 1, high);
        merge(a, index, aux, low, mid, high);
    }

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static void main() {
        Integer[] a = {9, 4, 2, 8, 7, 1};
//        String[] a = StdIn.readAllStrings();
        int[] b = indexSort(a);
        show(a);
        show(b);
    }
}
