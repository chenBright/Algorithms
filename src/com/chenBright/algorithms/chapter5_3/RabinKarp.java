package com.chenBright.algorithms.chapter5_3;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {
    private String pat; // 模式字符串
    private long patHash; // 模式字符串的散列值
    private int M; // 模式字符串的长度
    private long Q; // 一个很大的素数
    private int R = 256; // 字母表的大小
    private long RM; // R^(M - 1) % Q

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i < M - 1; i++) { // 计算R^(M - 1) % Q
            RM = (R * RM) % Q;            // 用于减去第一个数字时的计算
        }
        patHash = hash(pat, M);
    }

    // 蒙特卡罗算法
    public boolean check(int i) {
        return true; // 用于减去第一个数字时的计算
    }

    // 取留余数法计算散列值
    private long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (h * R + key.charAt(i)) % Q;
        }
        return h;
    }

    private int search(String txt) {
        // 在文中查找相等的散列值
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) {
            return 0; // 一开始就匹配成功
        }
        for (int i = M; i < N; i++) {
            // 减去第一个数字，加上最后一个数字，再次检测匹配
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                if (check(i - M + 1)) {
                    return i - M + 1; // 找到匹配
                }
            }
        }
        return N; // 未找到匹配
    }

    /**
     * Exercise 5.3.33
     *
     * @return
     */
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }


    public static void main() {
        String pat = "ABABAC";
        String txt = "BCBAABACAABABACAA";
        RabinKarp rabinKarp = new RabinKarp(pat);
        StdOut.println("text:    " + txt);
        int offset = rabinKarp.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);
    }
}
