package com.chenBright.algorithms.chapter5_3;

import edu.princeton.cs.algs4.StdOut;

public class BoyerMoore {
    private int[] right;
    private String pat;

    BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1; // 不包含在模式字符串中的字符的值为-1
        }
        for (int j = 0; j < M; j++) { // 包含在模式字符串中的字符的值为
            right[pat.charAt(j)] = j; // 它在其中出现的最右位置
        }
    }

    public int search(String txt) {
        // 在txt中查找模式字符串
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i < N - M; i++) {
            // 模式字符串和文本在位置i匹配吗？
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }
            if (skip == 0) {
                return i; // 找到匹配
            }
        }
        return N; // 为找到匹配
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
