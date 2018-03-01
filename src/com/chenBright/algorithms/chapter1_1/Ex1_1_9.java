package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/2/28.
 */
public class Ex1_1_9 {
    public static void main() {
        StdOut.println("1.1.7 请输入一个正整数：");

        int n = StdIn.readInt();
        String s = toBinaryString(n);
        StdOut.println(s);
    }
    public static String toBinaryString(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2 ) {
            s = (n % 2) + s;
        }
        return s;
    }
}
