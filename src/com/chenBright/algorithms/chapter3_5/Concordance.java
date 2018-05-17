package com.chenBright.algorithms.chapter3_5;

import edu.princeton.cs.algs4.*;

public class Concordance {
    private static final int CONTEXT = 5;

    public static void main() {
        ST<String, SET<Integer>> st = new ST<>();
        In in = new In("aminoI.txt");
        String[] words = in.readAllStrings();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!st.contains(word)) {
                st.put(word, new SET<Integer>());
            }
            st.get(word).add(i);
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                if (st.contains(query)) {
                    for (int pos : st.get(query)) {
                        for (int i = Math.max(0, pos - CONTEXT + 1); i < pos; i++) {
                            StdOut.print(words[i] + " ");
                        }
                        System.out.print("\"" + words[pos] + "\"");
                        for (int i = pos + 1; i < Math.min(words.length, pos + CONTEXT); i++) {
                            StdOut.print(" " + words[i]);
                        }
                        StdOut.println();
                    }
                }
            }
        }
    }
}
