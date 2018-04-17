package com.chenBright.algorithms.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/16.
 * 数组的局部最小元素。
 * 编写一个程序，给定一个含有 N 个不同整数的数组，找到一个局部最小元素：
 * 满足 a[i] < a[i-1]，且 a[i] < a[i+1] 的索引 i。
 * 程序在最坏情况下所需的比较次数为 ~ 2lgN。
 */
public class Ex1_4_18 {
    /**
     * 查找局部局部最小值（类似二分查找法）
     * @param arr 数组
     * @return 索引号
     */
    public static int localMin(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]) {
                return mid;
            }
            else {
                if (arr[mid - 1] < arr[mid]) {
                    high = mid - 1;
                }
                else if (arr[mid + 1] < arr[mid]) {
                    low = mid + 1;
                }
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    public static void main() {
        int[] arr = {5, 6, 5, 3, 5};
        StdOut.printf("局部最小值的索引号：%d\n", localMin(arr));
    }
}
