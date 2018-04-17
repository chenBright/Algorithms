package com.chenBright.algorithms.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/17.
 * 使用斐波那契数列划分区间进行的查找
 * https://www.cnblogs.com/ikesnowy/p/7467994.html
 */
public class Ex1_4_22 {
    /**
     * 使用斐波那契数列划分区间进行的查找
     * @param key 查找值
     * @param arr 数组（递增）
     * @return 索引号
     */
    public static int rank(int key, int[] arr) {
        int Fk = 1;
        int Fk1 = 1;
        int Fk2 = 0;

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (Fk <= high) {
            Fk = Fk + Fk1;
            Fk1 = Fk1 + Fk2;
            Fk2 = Fk - Fk1;
        }

        while (Fk2 >= 0) {
            mid = low + Fk2 > high ? high : low + Fk2;

            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] > key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }

            Fk = Fk1;
            Fk1 = Fk2;
            Fk2 = Fk - Fk1;
        }
        return -1;
    }

    public static void main() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i * 2;
        }

        StdOut.println(rank(198, arr) != -1);
    }
}
