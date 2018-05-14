package com.chenBright.algorithms.chapter3_2;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class Ex3_2_25 {
    public static BST<String, Integer> balance(String[] a) {
        Arrays.sort(a);
        BST<String, Integer> bst = new BST<>();
        balance(bst, a, 0, a.length - 1);
        return bst;
    }

    private static void balance(BST<String, Integer> bst, String[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = low + (high - low) / 2;
        bst.put(a[mid], mid);
        balance(bst, a, low, mid - 1);
        balance(bst, a, mid + 1, high);
    }

    public static void main() {
        String[] a = StdIn.readAllStrings();
        BST<String, Integer> bst = balance(a);
        for (String key : bst.keys()) {
            System.out.println(key + " " + bst.get(key));
        }
    }
}
