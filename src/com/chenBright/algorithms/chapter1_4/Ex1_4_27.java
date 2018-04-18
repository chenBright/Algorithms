package com.chenBright.algorithms.chapter1_4;

import com.chenBright.algorithms.chapter1_3.*;
/**
 * Created by chenbright on 2018/4/18.
 */
public class Ex1_4_27<Item> {
    private LinkedStack<Item> enStack; //用于保存入队元素
    private LinkedStack<Item> deStack; //用于保存出队元素

    public Ex1_4_27() {
        enStack = new LinkedStack<Item>();
        deStack = new LinkedStack<Item>();
    }

    public void enqueue(Item item) {
        enStack.push(item);
    }
    
    public Item dequeue() {
        if (deStack.isEmpty()) {
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
        return deStack.pop();
    }
}
