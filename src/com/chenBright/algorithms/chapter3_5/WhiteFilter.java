package com.chenBright.algorithms.chapter3_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

// 白名单过滤器
public class WhiteFilter {
    public static void main() {
        HashSet<String> set = new HashSet<>();
        In in = new In("list.txt");
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.contains(word)) {
                StdOut.print(word + " ");
            }
        }
    }
}
