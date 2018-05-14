package com.chenBright.algorithms.chapter3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class NonrecursiveBS<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public Key get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            }
            else if (cmp > 0) {
                node = node.right;
            }
            else {
                return node.key;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }
        Node node = root, parent = null;
        while (node != null) {
            parent = node;
           int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            }
            else if (cmp > 0) {
                node = node.right;
            }
            else {
                node.key = key;
                node.val = val;
            }
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = new Node(key, val);
        }
        else if (cmp > 0){
            parent.right = new Node(key, val);
        }
    }

    public Key min() {
        if (root == null) {
            return null;
        }
        Node node = root, parent = null;
        while (node != null) {
            parent = node;
            node = node.left;
        }
        // node为null，则parent为最小结点
        return parent.key;
    }

    public Key max() {
        if (root == null) {
            return null;
        }
        Node node = root, parent = null;
        while (node != null) {
            parent = node;
            node = node.right;
        }
        return parent.key;
    }

    // 非递归的中序遍历
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new Queue<Key>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                queue.enqueue(node.key);
                node = node.right;
            }
        }
        return queue;
    }
}
