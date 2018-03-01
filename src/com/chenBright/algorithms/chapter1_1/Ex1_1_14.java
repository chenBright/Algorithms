package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_14 {
    public static int lg(int N, int M) {
        int index = 0;
        while (N >= M) {
            N /= M;
            index++;
        }
        return index;
    }
    public static void main() {
        StdOut.println("1.1.14 请输入一个整数:");
        int n = StdIn.readInt();
        int index = lg(n, 2);
        StdOut.println(index);
    }
}
