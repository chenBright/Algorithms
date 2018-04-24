package com.chenBright.algorithms.chapter2_1;

/**
 * Created by chenbright on 2018/4/24.
 */
public class Ex_2_1_24 extends BaseSort {
    public static void sort(Comparable[] a) {
        int len = a.length;
        int exchange = 0; // 交换次数
        // 将最小元素移动到a[0]
        for (int i = len - 1; i > 0 ; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                exchange++;
            }
        }
        // 如果没有发生交换，则表示数组有序，直接返回
        if (exchange == 0) {
            return;
        }

        for (int i = 0; i < len - 1; i++) {
            Comparable temp = a[i];
            int j = i;
            for (j = i; less(a[j], a[j - 1]); j--) {
               a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }
}
