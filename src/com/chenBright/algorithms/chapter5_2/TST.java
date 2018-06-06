package com.chenBright.algorithms.chapter5_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Quick;

public class TST<Value> {
    private Node root;

    private class Node {
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x  == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        }
        else if (c > x.c) {
            return get(x.right, key, d);
        }
        else if (d < key.length() - 1){
            return get(x.mid, key, d + 1);
        }
        else {
            return x;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        }
        else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        }
        else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        }
        else {
            x.val = val;
        }
        return x;
    }

    // Exercise 5.2.9

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }
        if (x.val != null) {
            length = d;
        }
        if (d == s.length()) {
            return length;
        }
        char c = s.charAt(d);
        if (c < x.c) {
            return search(x.left, s, d, length);
        }
        else if (c > x.c) {
            return search(x.right, s, d, length);
        }
        else {
            return search(x.mid, s, d + 1, length);
        }
    }

    public Iterable<String> keys() {
        return keysWithprefix("");
    }

    public Iterable<String> keysWithprefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            q.enqueue(pre);
        }
        collect(x.left, pre, q);
        collect(x.mid, pre + x.c, q);
        collect(x.right, pre, q);
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        if (x == null) {
            return;
        }
        int d = pre.length();
        char c = pat.charAt(d);
        if (c == '.' || c < x.c) {
            collect(x.left, pre, pat, q);
        }
        if (c == '.' || c > x.c) {
            collect(x.right, pre, pat, q);
        }
        if (c == '.' || c == x.c) {
            if (d + 1 == pat.length() && x.val != null) {
                q.enqueue(pre + c);
            }
            if (d + 1 < pat.length()) {
                collect(x.mid, pre + c, pat, q);
            }
        }
    }
}
