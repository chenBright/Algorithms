package com.chenBright.algorithms.chapter1_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/16.
 * 字符串定容栈
 */
public class FixedCapacityStackOfStrings {
    private String[] stack; // 栈元素数组
    private int number; // 栈中字符串的数量

    /**
     * 创建一个容量为cap的空栈
     * @param cap 容量
     */
    public FixedCapacityStackOfStrings(int cap) {
        stack = new String[cap];
        number = 0;
    }

    /**
     * 添加一个字符串
     * @param item 字符串
     */
    public void push(String item) {
        if (stack.length == number) {
            StdOut.println("栈已满！");
        }
        else {
            stack[number++] = item;
        }
    }

    /**
     * 删除最近添加的字符串
     * @return 被删除的字符串
     */
    public String pop() {
        if (isEmpty()) {
            StdOut.println("空栈！");
        }
        return stack[--number];
    }

    /**
     * 栈是否为空
     * @return true / false
     */
    public boolean isEmpty() {
        return number == 0;
    }

    /**
     * 栈是否满
     * @return true / false
     */
    public boolean isFull() {
        return stack.length == number;
    }

    /**
     * 栈中字符串的数量
     * @return 数量
     */
    public int size() {
        return number;
    }

    public static void main() {
        FixedCapacityStackOfStrings str = new FixedCapacityStackOfStrings(100);

        try {
            FileInputStream input = new FileInputStream("./data/tobe.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                str.push(item);
            }
            else if (!str.isEmpty()) {
                StdOut.print(str.pop() + " ");
            }
        }
        StdOut.println("(" + str.size() + " left on stack)");
    }
}
