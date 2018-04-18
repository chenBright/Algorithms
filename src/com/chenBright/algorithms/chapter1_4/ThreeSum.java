package com.chenBright.algorithms.chapter1_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/15.
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main() {
        String[] files = {"./data/1Kints.txt", "./data/2Kints.txt", "./data/4Kints.txt", "./data/8Kints.txt", "./data/1Mints.txt"};
        try {
            FileInputStream input = new FileInputStream(files[0]);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] a = StdIn.readAllInts();
        StdOut.println(count(a));
    }
}
