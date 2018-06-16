package com.chenBright.algorithms.chapter5_5;

import edu.princeton.cs.algs4.BinaryStdOut;

public class RandomBits {
    public static void main() {
        int x = 11111;
        for (int i = 0; i < 1000000; i++) {
            x = x * 314159 + 218281;
            BinaryStdOut.write(x > 0);
        }
        BinaryStdOut.close();
    }
}
