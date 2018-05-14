package com.chenBright.algorithms.chapter3_2;

import com.chenBright.algorithms.chapter1_3.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key; // 键
        private Value val; // 值
        private Node left, right; // 左右子树
        private int n;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return node.n;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        // 最高子树 + 1（本结点的一层）
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        }
        else if (cmp < 0) {
            return get(node.left, key);
        }
        else {
            return node.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = put(node.right, key, val);
        }
        else if (cmp < 0) {
            node.left = put(node.left, key, val);
        }
        else {
            node.val = val;
        }
        node.n = size(node.right) + size(node.left) + 1;
        return node;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        else {
            return max(node.right);
        }
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        else {
            return node.key;
        }
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node t = floor(node, key);
        if (t == null) {
            return node;
        }
        else {
            return t;
        }
    }

    public Key ceiling(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        else {
            return node.key;
        }
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp > 0) {
            return ceiling(node.right, key);
        }
        Node t = ceiling(node.left, key);
        if (t == null) {
            return node;
        }
        else {
            return t;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int leftSize = size(node.left);
        if (leftSize > k) {
            return select(node.left, k);
        }
        else if (leftSize < k) {
            return select(node.right, k - leftSize - 1);
        }
        else {
            return node;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        }
        else if (cmp > 0) {
            return size(node.left) + 1 +rank(node.right, key);
        }
        else {
            return size(node.left);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMin(root);
    }

    private Node deleteMax(Node node) {
        if (node == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        }
        else if (cmp > 0) {
            node.right = delete(node, key);
        }
        else {
            if (node.right == null) {
                return node.left;
            }
            else if (node.left == null) {
                return node.right;
            }
            else {
                Node t = node;
                node = min(node.right); // 被删除结点的后继结点
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key low, Key high) {
        if (node == null) {
            return;
        }
        int cmpLow = low.compareTo(node.key);
        int cmpHigh = high.compareTo(node.key);
        if (cmpLow < 0) {
            keys(node.left, queue, low, high);
        }
        if (cmpLow <= 0 && cmpHigh >= 0) {
            queue.enqueue(node.key);
        }
        if (cmpHigh > 0) {
            keys(node.right, queue, low, high);
        }
    }
}
