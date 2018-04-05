package com.chenBright.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * Created by chenbright on 2018/4/5.
 * 链栈
 */
public class ListStack<Item> implements Iterable<Item> {
    private Node head; // 头结点
    private int number; // 结点个数

    public class Node {
        Item item;
        Node next;
    }

    /**
     * 创建带头结点的空栈
     */
    public ListStack() {
        head = new Node();
        head.next = null;
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
     * 栈元素个数
     * @return 个数
     */
    public int size() {
        return number;
    }

    /**
     * 入栈
     * @param item 入栈元素
     */
    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head.next;
        head.next = newNode;
        number++;
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public Item pop() {
        Node firstNode = head.next;
        head.next = firstNode.next;
        number--;
        return firstNode.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = head.next;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {}
    }
}
