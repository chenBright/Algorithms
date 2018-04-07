package com.chenBright.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/6.
 */
public class Parenthess {
    public static void main() {
        LinkedStack<String> stack = new LinkedStack<String>();
        String str = StdIn.readString();
        String[] parenthesis = str.split("");

        for (String s : parenthesis) {
           if (s.equals("(") || s.equals("[") || s.equals("{")) {
               stack.push(s);
           }
           else if (!stack.isEmpty()) {
               if (s.equals(")")) {
                   String parenthess = stack.pop();
                   if (!parenthess.equals("(")) {
                       StdOut.println(false);
                       return;
                   }
               }
               else if (s.equals("]")) {
                   String parenthess = stack.pop();
                   if (!parenthess.equals("[")) {
                       StdOut.println(false);
                       return;
                   }
               }
               else if (s.equals("}")) {
                   String parenthess = stack.pop();
                   if (!parenthess.equals("{")) {
                       StdOut.println(false);
                       return;
                   }
               }
           }
        }
        StdOut.println(stack.isEmpty());
    }
}
