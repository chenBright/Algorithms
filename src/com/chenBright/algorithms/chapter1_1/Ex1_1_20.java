package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_20 {
    public static double factorialln(int N) {
        if (N > 0) {
            return Math.log(N) + factorialln(N - 1);
        }
        else {
            return 0;
        }
    }
    public static void main() {
        StdOut.printf("1.1.20：\n%f", factorialln(10));
    }
}
