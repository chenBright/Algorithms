package com.chenBright.algorithms.chapter2_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Heap {
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int k = len / 2; k >= 1; k--) {
            sink(a, k, len);
        }
        while (len > 1) {
            exch(a, 1, len--);
            sink(a, 1, len);
        }
    }
    /**
     * 由上至下的堆有序化（下沉）
     * @param k 下沉第k个结点
     */
    private static void sink(Comparable[] pq, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            // 找到最大的子结点
            if (j < N && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main() {
        String[] a = {"0", "9", "8", "7", "6", "5", "4"};
        Heap.sort(a);
        show(a);
    }
}
