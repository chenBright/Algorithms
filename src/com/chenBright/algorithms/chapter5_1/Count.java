package com.chenBright.algorithms.chapter5_1;


import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Count {
    public static void main() {
        String str = StdIn.readString();
        Alphabet alpha = new Alphabet(str);
        int R = alpha.radix();
        int[] count = new int[R];

        try {
            FileInputStream input = new FileInputStream("./data/abra.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = StdIn.readAll();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alpha.contains(s.charAt(i))) {
                count[alpha.toIndex(s.charAt(i))]++;
            }
        }
        for (int c = 0; c < R; c++) {
            StdOut.println(alpha.toChar(c) + " " + count[c]);
        }
    }
}
