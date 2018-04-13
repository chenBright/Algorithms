package com.chenBright.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/13.
 */
public class Josephus {
    public static void main() {
        StdOut.print("请输入人数（大于1）：");
        int N = StdIn.readInt();
        StdOut.print("请输入杀死第几个人：");
        int M = StdIn.readInt();

        if (N <= 1) {
            StdOut.println("输入有误");
        }

        Queue<Integer> queque = new Queue<Integer>();
        for (int i = 0; i < N; i++) {
            queque.enqueue(i);
        }

        while (queque.size() != 1) {
            for (int i = 1; i < M; i++) {
                queque.enqueue(queque.dequeue());
            }
            StdOut.printf("%d ", queque.dequeue());
        }
        StdOut.println();
        StdOut.printf("序号为 %d 的人留了下来（序号从0开始）", queque.dequeue());
    }
}
