package com.chenBright.algorithms.chapter2_5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class LPT {
    public static void main() {
        StdOut.print("请输入处理器数量m：");
        int m = StdIn.readInt();
        StdOut.print("请输入任务书n：");
        int n = StdIn.readInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            jobs[i] = new Job(name, time);
        }
        // 对任务排序
        Arrays.sort(jobs);
        // 处理器优先队列
        MinPQ<Processor> pq = new MinPQ<Processor>(m);
        for (int i = 0; i < m; i++) {
            pq.insert(new Processor());
        }
        // 分配任务
        for (int i = n - 1; i >= 0 ; i++) {
            // 将优先级最小的任务出队
            Processor min = pq.delMin();
            min.insert(jobs[i]);
            pq.insert(min);
        }
        // 打印每个处理器的任务
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMin());
        }
    }
}
