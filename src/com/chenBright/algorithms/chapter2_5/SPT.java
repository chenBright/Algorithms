package com.chenBright.algorithms.chapter2_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

// 习题2.5.12
public class SPT {
    public static void main() {
        int n = StdIn.readInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            jobs[i] = new Job(name, time);
        }

        Arrays.sort(jobs);
        for (int i = 0; i < n; i++) {
            System.out.println(jobs[i]);
        }
    }
}
