package com.chenBright.algorithms.chapter5_1;

/**
 * 基于健索引计数法的低位优先字符串排序
 */
public class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0 ; d--) {
            int[] count = new int[R + 1];

            // 计算出现的频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d)]++;
            }

            // 将频率转化为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // 将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // 回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
