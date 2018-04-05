package com.chenBright.algorithms.chapter1_3;

import java.util.Iterator;

/**
 * Created by chenbright on 2018/4/5.
 */
public class Queue<Item> implements Iterable<Item> {
    private Node head; // 头结点
    private Node tail; // 尾结点
    private int number;

    public class Node {
        Item item;
        Node next;
    }

    public Queue() {
        head = new Node();
        head.next = null;
        // 在空队列中，尾结点和头结点为同一结点
        tail = head;
        number = 0;
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public int size() {
        return number;
    }

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        number++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        else {
            Node firstNode = head.next;
            head.next = firstNode.next;
            // 如果出队后为空队列，，尾结点和头结点为同一结点
            if (isEmpty()) {
                tail = head;
            }
            number--;
            return firstNode.item;
        }
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
