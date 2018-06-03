package com.chenBright.algorithms.chapter5_1;

public class MSD {
    private static int R = 256;
    private static final int M = 15; // 小数组的切换阈值
    private static String[] aux; // 数据分类的辅助数组

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }
        else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    public static void sort(String[] a, int low, int high, int d) {
        if (high - low >= M) {
            Insertion.sort(a, low, high, d);
        }

        int[] count = new int[R + 2];

        // 计算频率
        for (int i = low; i <= high; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        // 将频率转化为索引
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] = count[r];
        }

        // 数据分类
        for (int i = low; i <= high ; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        // 回写
        for (int i = low; i < high; i++) {
            a[i] = aux[i - low];
        }

        // 对每个小组进行递归排序
        for (int r = 0; r < R; r++) {
            sort(a, low + count[r], low + count[r + 1], d + 1);
        }
    }
}
