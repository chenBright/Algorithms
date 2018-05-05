package com.chenBright.algorithms.chapter2_4;

/**
 * Created by chenbright on 2018/5/5.
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    private Key min;

    /**
     * 构造函数
     * @param max 队列最大容量
     */
    public OrderedArrayMaxPQ(int max) {
        pq = (Key[]) new Comparable[max];
    }

    /**
     * 向优先队列中插入一个元素
     * @param v 元素
     */
    public void insert(Key v) {
        pq[N++] = v;
        for (int i = N - 1; i > 0 && less(i, i - 1); i++) {
            exch(i, i - 1);
        }
    }

    /**
     * 优先队列是否为空
     * @return true / false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 优先队列中元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 返回最大元素
     * @return
     */
    public Key max() {
        return pq[N - 1];
    }

    /**
     * 删除并返回最大元素
     * @return
     */
    public Key delMax() {
        return pq[--N];
    }

    /**
     * 优先队列中索引号为i的元素是否比索引号为j的元素小
     * @param i
     * @param j
     * @return true / false
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 将索引号为i的元素和索引号为j的元素交换位置
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
