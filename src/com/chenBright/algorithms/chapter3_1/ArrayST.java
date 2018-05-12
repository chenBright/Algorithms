package com.chenBright.algorithms.chapter3_1;

import com.chenBright.algorithms.chapter1_3.Queue;
import org.omg.CORBA.Object;

public class ArrayST<Key, Value> {
    private static final int INIT_SIZE = 8;

    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    public ArrayST() {
        keys = (Key[]) new Object[INIT_SIZE];
        vals = (Value[]) new Object[INIT_SIZE];
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            tempk[i] = keys[i];
        for (int i = 0; i < n; i++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }

    public void put(Key key, Value val) {
        delete(key);

        if (n >= vals.length) {
            resize(2 * n);
        }

        keys[n] = key;
        vals[n] = val;
        n++;
    }

    public Value get(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                return vals[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[n - 1];
                vals[i] = vals[n - 1];
                keys[n - 1] = null;
                vals[n - 1] = null;
                n--;
                if (n > 0 && n == keys.length / 4) {
                    resize(n / 2);
                }
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }
}
