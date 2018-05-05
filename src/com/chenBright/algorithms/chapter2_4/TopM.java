package com.chenBright.algorithms.chapter2_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.princeton.cs.algs4.*;

/**
 * Created by chenbright on 2018/5/4.
 */
public class TopM {
    public static void main() {
        StdOut.println("请输入一个整数：");
        int M = StdIn.readInt();
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);

        try {
            FileInputStream input = new FileInputStream("./data/tinyBatch.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction((StdIn.readLine())));
            if (pq.size() > M) {
                pq.delMin(); // 如果优先队列中存在 N + 1 个元素，则删除其中最小的元素
            }
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) {
            stack.push(pq.delMin());
        }
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }
}
