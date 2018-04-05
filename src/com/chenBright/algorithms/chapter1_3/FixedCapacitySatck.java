package com.chenBright.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

    /**
     * Created by chenbright on 2018/3/17.
     * 定容栈
     */
    public class FixedCapacitySatck<Item> {
        private Item[] stack; // 栈元素数组
        private int number; // 栈元素个数

    /**
     * 穿件一个容量为cap的栈
     * @param cap 容量
     */
    public FixedCapacitySatck(int cap) {
        stack = (Item[]) new Object[cap];
        number = 0;
    }

    /**
     * 栈是否为空
     * @return true / false
     */
    public boolean isEmpty() {
        return number == 0;
    }

    /**
     * 栈是否已满
     * @return true / false
     */
    public boolean isFull() {
        return stack.length == number;
    }

    /**
     * 栈中元素数量
     * @return 数量
     */
    public int size() {
        return number;
    }

    /**
     * 入栈
     * @param item 入栈元素
     */
    public void push(Item item) {
        if (stack.length == number) {
            StdOut.println("栈已满！");
        }
        else {
            stack[number++] = item;
        }
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public Item pop() {
        Item item = stack[--number];
        stack[number] = null;
        return item;
    }

    public static void main() {
        FixedCapacitySatck<String> str = new FixedCapacitySatck<String>(100);

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
