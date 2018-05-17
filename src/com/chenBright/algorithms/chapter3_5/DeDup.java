package com.chenBright.algorithms.chapter3_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

// DeDup过滤器
public class DeDup {
    public static void main() {
        HashSet<String> set = new HashSet<>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.print(key + " ");
            }
        }
    }
}
