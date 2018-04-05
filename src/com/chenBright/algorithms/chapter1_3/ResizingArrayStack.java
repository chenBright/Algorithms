package com.chenBright.algorithms.chapter1_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by chenbright on 2018/4/5.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] stack = (Item[]) new Object[1]; // 栈元素数组
    private int number = 0; // 栈元素个数


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
            resize(2 * stack.length);
        }
        stack[number++] = item;
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public Item pop() {
        Item item = stack[--number];
        stack[number] = null;
        if (number > 0 && number == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    /**
     * 调整栈容量
     * @param max
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < number; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = number;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }

        @Override
        public void remove() {}
    }

    public static void main() {
        ResizingArrayStack<String> str = new ResizingArrayStack<String>();

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

        // foreach 迭代
        for (String s : str) {
            StdOut.print(s + " ");
        }
    }
}
