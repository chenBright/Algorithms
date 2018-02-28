package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/2/28.
 */
public class Ex1_1_3 {

    public static void main() {
        StdOut.println("1.1.3 请输入三个整数");
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if (a == b && b == c && a== c) {
            StdOut.println("equal");
        }
        else {
            StdOut.println("not equal");
        }
    }
}
