package com.chenBright.algorithms.chapter2_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

// 习题2.5.8
public class Frequency {
    public static void main() {
        String[] a = StdIn.readAllStrings();
        Arrays.sort(a);
        int len = a.length;
        Record[] records = new Record[len];
        records[0] = new Record(a[0]);
        int m = 0;
        for (int i = 1; i < len; i++) {
            if (records[m].getWord().equals(a[i])) {
                records[m].addFreq();
            }
            else {
                records[++m] = new Record(a[i]);
            }
        }
        Arrays.sort(records, 0, m);
        for (int i = 0; i <= m; i++) {
            Record record = records[i];
            System.out.println(record.getWord() + ": " + record.getFreq());
        }
    }
}
