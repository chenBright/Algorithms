package com.chenBright.algorithms.chapter1_1;

import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by chenbright on 2018/3/1.
 */
public class Ex1_1_32 {
    public static void main() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            list.add(scanner.nextDouble());
        }
        int N = StdIn.readInt();
        double l = StdIn.readDouble(), r = StdIn.readDouble();
        int[] num = new int[N];
        int max = 0;
        double step = (r - l) / N;
        for (int i = 0; i < list.size(); i++) {
            double element = list.get(i);
            if (element >= l && element <= r) {
                for (int j = 0; j < N; j++) {
                    if (element > l + step * j && element <= l + step * j + step) {
                        num[j]++;
                        if (max < num[j]) {
                            max = num[j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            double x = (1.0 * i + 0.5) / N;
            double y = num[i] / (max * 2.0);
            double rw = 0.4 / N;
            StdDraw.filledRectangle(x, y, rw, y);
        }
    }
}
