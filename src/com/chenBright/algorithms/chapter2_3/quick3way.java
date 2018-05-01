package com.chenBright.algorithms.chapter2_3;

/**
 * Created by chenbright on 2018/5/1.
 * 三向切分的快排
 */
public class quick3way extends BaseQuickSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low, i = lt + 1, gt = high;
        Comparable temp = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(temp);
            // 将比切分元素小的元素放到[low, lt - 1]
            if (cmp < 0) {
                exch(a, lt++, i++);
            }
            // 将比切分元素大的元素放到[gt + 1, high]
            else if (cmp > 0) {
                exch(a, i, gt--);
            }
            // 与切分元素相等的元素放到[lt, i]
            else {
                i++;
            }
        } // 现在 a[low...lt - 1] < v = a[lt...gt] < a[gt+1..high]
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }
}
