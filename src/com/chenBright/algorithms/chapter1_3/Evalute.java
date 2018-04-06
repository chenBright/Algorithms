package com.chenBright.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/6.
 * Dijkstra 双栈算术表达式求值算法
 */
public class Evalute {
    public static void main() {
        ListStack<String> ops = new ListStack<String>();
        ListStack<Double> vals = new ListStack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) {
                ops.push(s);
            }
            else if (s.equals("-")) {
                ops.push(s);
            }
            else if (s.equals("*")) {
                ops.push(s);
            }
            else if (s.equals("/")) {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String op = ops.pop();
                double val = vals.pop();
                if (op.equals("+")) {
                    val = val + vals.pop();
                }
                else if (op.equals("-")) {
                    val = val - vals.pop();
                }
                else if (op.equals("*")) {
                    val = val * vals.pop();
                }
                else if (op.equals("/")) {
                    val = val / vals.pop();
                }
                vals.push(val);
            }
            else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
