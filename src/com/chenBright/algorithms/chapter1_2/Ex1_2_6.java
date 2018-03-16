package com.chenBright.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/16.
 */
public class Ex1_2_6 {
    public static void main() {
        StdOut.println("1.2.1：");
        StdOut.println("请输入字符串s：");
        String s = StdIn.readString();

        StdOut.println("请输入字符串t：");
        String t = StdIn.readString();

        boolean isCRString = isCRString(s, t);
        StdOut.printf("s与t是否互为回环变位：%s", isCRString);
    }

    /**
     * 判断字符串s和t是否互为回环变位
     * @param s 字符串
     * @param t 字符串
     * @return true / false
     */
    public static boolean isCRString(String s, String t) {
        return (s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0);
    }
}
