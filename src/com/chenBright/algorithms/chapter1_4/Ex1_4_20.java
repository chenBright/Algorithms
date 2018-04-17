package com.chenBright.algorithms.chapter1_4;

import com.chenBright.algorithms.chapter1_1.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/17.
 */
public class Ex1_4_20 {
    /**
     * 获取双调数组局部最大值的索引值
     * @param arr 双调数组
     * @return 索引值
     */
    private static int indexOfMax(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else {
                if (arr[mid] < arr[mid - 1]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    /**
     * 二分查找
     * @param key 查找的值
     * @param arr 数组（递减）
     * @param low 实际查找范围的起始值
     * @param high 实际查找范围的末尾值
     * @return true / false
     */
    private static int rank(int key, int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        while (low <= high) {
            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] < key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    /**
     * 双调数组是否含有给定值
     * @param key 查找值
     * @param arr 双调数组
     * @return true / false
     */
    private static boolean contains(int key, int[] arr) {
        int maxIndex = indexOfMax(arr);
        if (maxIndex == -1) {
            StdOut.println("数组不是双调数组");
            return false;
        }

        if (BinarySearch.rank(key, arr, 0, maxIndex) != -1) {
            return true;
        }
        else if (rank(key, arr, maxIndex, arr.length - 1) != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main() {
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2};
        int key = 6;
        StdOut.print("双调数组：");
        for (int item : arr) {
            StdOut.print(item + ' ');
        }
        StdOut.printf("\n是否包含%d：", key);
        StdOut.println(contains(key, arr));
    }
}
