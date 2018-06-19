package com.chenBright.algorithms.chapter6;

import edu.princeton.cs.algs4.Quick3way;

public class SuffixArray {
    private final String[] suffixes; // 后缀数组
    private final int N; // 字符串（和数组）的长度

    public SuffixArray(String s) {
        N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i);
        }
        Quick3way.sort(suffixes);
    }

    public int length() {
        return N;
    }

    public String select(int i) {
        return suffixes[i];
    }

    public int index(int i) {
        return N - suffixes[i].length();
    }

    public static int lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }
        return N;
    }

    public int lcp(int i) {
        return lcp(suffixes[i], suffixes[i - 1]);
    }

    public int rank(String key) {
        int low = 0, high = N - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(suffixes[mid]);
            if (cmp < 0) {
                high = mid - 1;
            }
            else if (cmp > 0) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return low;
    }
}
