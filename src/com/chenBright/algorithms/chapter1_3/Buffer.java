package com.chenBright.algorithms.chapter1_3;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/14.
 */
public class Buffer implements Iterable {
    LinkedStack<Character> front = new LinkedStack<Character>();
    LinkedStack<Character> after = new LinkedStack<Character>();

    public int size() {
        return front.size() + after.size();
    }

    public void insert(Character c) {
        front.push(c);
    }

    public char delete() {
        return front.pop();
    }

    public void left(int k) {
        if(k >= front.size()) {
            return;
        }
        for(int i = 0; i < k; i++) {
            after.push(front.pop());
        }
    }
    public void right(int k) {
        if(k>after.size()) {
            return;
        }
        for(int i = 0; i < k; i++) {
            front.push(after.pop());
        }
    }

    public Iterator iterator() {
        return new BufferIterator();
    }
    private class BufferIterator implements Iterator{


        Iterator<Character> it;
        public BufferIterator(){
            LinkedStack<Character> afterTemp = new LinkedStack<Character>();
            LinkedStack<Character> temp = new LinkedStack<Character>();
            // 两个foreach，将after的元素拷贝到temp中
            for (Character c : after) {
                afterTemp.push(c);
            }
            for (Character c : afterTemp) {
                temp.push(c);
            }
            // 拷贝front的元素
            for (Character c : front)
                temp.push(c);
            it = temp.iterator();
        }
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Character next() {
            return it.next();
        }

        @Override
        public void remove() {}

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Buffer b = new Buffer();
        String s = "Hellow word!";
        for(int i=0;i<s.length();i++){
            b.insert(s.charAt(i));
        }
        for(Object c:b)
            StdOut.print(c);
        StdOut.println();
        b.left(6);
        b.delete();
        for(Object c:b)
            StdOut.print(c);
        StdOut.println();
        b.right(4);
        b.insert('l');
        for(Object c:b)
            StdOut.print(c);
        StdOut.println();
    }
}
