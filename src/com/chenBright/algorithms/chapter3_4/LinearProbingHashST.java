package com.chenBright.algorithms.chapter3_4;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
    private int N; // 符号表中键值对的总数
    private int M; // 线性探测表的大小
    private Key[] keys; // 健
    private Value[] vals; // 值

    public LinearProbingHashST(int capacity) {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        M    = temp.M;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) {
            resize(2 * M);
        }

        int i;
        for (i = hash(key);  keys[i] != null;  i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }

    public void delete(Key key) {
       if (!contains(key)) {
           return;
       }
       int i = hash(key);
       while (!key.equals(keys[i])) {
           i = (i + 1) % M;
       }
       keys[i] = null;
       vals[i] = null;
        N--;
        // 将被删除健后面的簇健重新散列
        for (int j = i + 1; keys[j] != null; j = (j + 1) % M) {
            Key keyToRedo = keys[j];
            Value valToRedo = vals[j];
            keys[j] = null;
            vals[j] = null;
            N--;
            put(keyToRedo, valToRedo);
        }
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }
}
