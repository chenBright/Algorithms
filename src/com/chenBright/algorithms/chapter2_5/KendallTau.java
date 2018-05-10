package com.chenBright.algorithms.chapter2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import com.chenBright.algorithms.chapter2_2.Ex2_2_19;

// 习题2.5.19
public class KendallTau {
    public static int distance(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array dimensions disagree");
        }
        int n = a.length;

        int[] aIndex = new int[n];
        // a数组的索引为b数组中对应元素的"值"或"优先级"
        for (int i = 0; i < n; i++) {
            aIndex[a[i]] = i;
        }

        Integer[] bIndex = new Integer[n];
        // "计算"b数组中每个元素的"值"
        for (int i = 0; i < n; i++) {
            bIndex[i] = aIndex[b[i]];
        }
        // 归并排序计算逆序数
        return Ex2_2_19.count(bIndex);
    }

    public static void main() {
        int n = StdIn.readInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
            b[i] = i;
        }
        StdRandom.shuffle(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        StdRandom.shuffle(b);
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println("distance: " + distance(a, b));
    }
}
