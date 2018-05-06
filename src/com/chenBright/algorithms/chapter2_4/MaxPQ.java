package com.chenBright.algorithms.chapter2_4;

/**
 * Created by chenbright on 2018/5/5.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int MaxN) {
        pq = (Key[]) new Comparable[MaxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null; // 防止对象游离
        sink(1);
        return max;
    }

    /**
     * 由下至上的堆有序化（上浮）
     * @param k 上浮第k个结点
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上至下的堆有序化（下沉）
     * @param k 下沉第k个结点
     */
    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            // 找到最大的子结点
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
