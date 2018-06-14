package com.chenBright.algorithms.chapter5_3;

import edu.princeton.cs.algs4.StdOut;

// KMP next数组实现
public class KMPNext {
    private String pat;
    private int[] next;

    public KMPNext(String pat) {
        this.pat = pat;
        int M = pat.length(); // 模式字符串长度
        next = new int[M]; // 初始化next数组
        next[0] = -1; // 第一个元素默认为-1
        int k = -1;
        int j = 0;
        // 构造next数组
        while (j < M - 1) {
            if (k == -1 || next[j] == next[k]) {
                j++;
                k++;
                next[k]++;
            }
            else {
                k = next[k];
            }
        }
    }

    public int search(String txt) {
        int i = 0; // 文本字符串的索引
        int j = 0; // 模式字符串的索引

        int txtLen = txt.length();
        int patLen = pat.length();

        while (i < txtLen && j < pat.length()) {
            if (j == 0 || txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }

        if (j == patLen) {
            return i - j;
        }
        else {
            return -1;
        }
    }

    public static void main() {
        String pat = "ABABAC";
        String txt = "BCBAABACAABABACAA";
        KMP kmp = new KMP(pat);
        StdOut.println("text:    " + txt);
        int offset = kmp.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);
    }
}
