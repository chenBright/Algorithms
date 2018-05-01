package com.chenBright.algorithms.chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by chenbright on 2018/5/1.
 */
public class Quick extends BaseQuickSort {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high;
        Comparable temp = a[low]; // 切分元素
        while (true) {
            // 向右扫描
            while (less(a[++i], temp)) {
                if (i == high) {
                    break;
                }
            }
            // 向左扫描
            while (less(temp, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        // 将切分元素放到最终位置
        exch(a, low, j);
        return j;
    }
}
