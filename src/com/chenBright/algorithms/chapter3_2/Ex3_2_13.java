package com.chenBright.algorithms.chapter3_2;

import edu.princeton.cs.algs4.StdIn;

public class Ex3_2_13<Key extends Comparable<Key>, Value> {
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
            node.left = new Node(key, val);
        }
        else if (cmp > 0){
            node.right = new Node(key, val);
        }
    }
}
