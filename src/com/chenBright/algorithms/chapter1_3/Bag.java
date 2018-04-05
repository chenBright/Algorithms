package com.chenBright.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * Created by chenbright on 2018/4/5.
 * 背包
 */
public class Bag<Item> implements Iterable<Item> {
    private Node head; // 头结点
    private int number;

    /**
     * 结点类
     */
    private class Node {
        Item item;
        Node next;
    }

    /**
     * 创建带头结点的空背包
     */
    public Bag() {
        // 初始化头结点
        head = new Node();
        head.next = null;
    }

    /**
     * 背包是否为空
     * @return true / false
     */
    public boolean isEmpty() {
        return number == 0;
    }

    /**
     * 背包中元素数量
     * @return 数量
     */
    public int size() {
        return number;
    }

    /**
     * 添加元素
     * @param item 元素
     */
    public void add(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head.next;
        head.next  = newNode;
        number++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = head.next; // 第一个结点

        @Override
        public boolean hasNext() {
            return current != null;
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
