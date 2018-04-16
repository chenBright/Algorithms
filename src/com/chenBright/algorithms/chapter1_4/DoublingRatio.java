package com.chenBright.algorithms.chapter1_4;


import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/16.
 */
public class DoublingRatio {
    public static void main() {
        double prev = DoublingTest.timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = DoublingTest.timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
