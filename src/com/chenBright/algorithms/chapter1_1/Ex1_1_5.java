package com.chenBright.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/2/28.
 */
public class Ex1_1_5 {
    public static void main() {
        StdOut.println("1.1.5 请输入两个浮点数：");
        double a = StdIn.readDouble();
        double b = StdIn.readDouble();

        if (isBetween0and1(a) == true && isBetween0and1(b) == true) {
            StdOut.println("true");
        }
        else {
            StdOut.println("false");
        }
    }
    public static boolean isBetween0and1(double number) {
        if (number > 0 && number < 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
