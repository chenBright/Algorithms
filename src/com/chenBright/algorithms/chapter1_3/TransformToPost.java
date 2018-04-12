package com.chenBright.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/7.
 * 转换中序表达式
 */
public class TransformToPost {
    public static void transform(String expression) {
        LinkedStack<String> operatorStack = new LinkedStack<String>();
        String[] expressions = expression.split("");
        int len = expressions.length;

        for (int i = 0; i < len; i++) {
            String str = expressions[i];
            // 参考 https://blog.csdn.net/zhufenghao/article/details/48863163
            // https://www.cnblogs.com/hsrzyn/archive/2009/12/21/1629274.html
            // // 如果是左括号，则直接入栈
            if (str.equals("(")) {
                operatorStack.push(str);
            }
            // 如果是右括号，则一直出栈，直到栈顶元素为左括号
            else if (str.equals(")")) {
                String operator = operatorStack.pop();
                while (!operator.equals("(")) {
                    StdOut.print(operator);
                    operator = operatorStack.pop();
                }
            }
            // 如果是运算符
            else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                // + - 运算符
                if (str.equals("+") || str.equals("-")) {
                    // 如果栈为空，则直接入栈
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(str);
                    }
                    else { // 栈不为空
                        // 只要栈顶元素不为左括号（即为运算符），则栈顶元素的优先级比str（即当前）运算符的优先级高（运算表达式的左结合性），所以出栈
                        if (!operatorStack.peek().equals("(")) {
                            StdOut.print(operatorStack.pop());
                        }
                        // 当前运算符入栈
                        operatorStack.push(str);
                    }
                }
                // / * 运算符
                else if (str.equals("/") || str.equals("*")) {
                    // 如果栈为空，则直接入栈
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(str);
                    }
                    else { // 栈不为空
                        // 如果栈顶元素不为左括号（即为运算符）且栈顶元素为运算符 / 或 * ，则栈顶元素的优先级比str（即当前）运算符的优先级高，所以出栈
                        if (!operatorStack.peek().equals("(") && (operatorStack.peek().equals("/") || operatorStack.peek().equals("*"))) {
                            StdOut.print(operatorStack.pop());
                        }
                        // 当前运算符入栈
                        operatorStack.push(str);
                    }
                }
            }
            else {
                // 如果为数字，则直接打印
                StdOut.print(str);
            }
        }
        // 打印栈中剩余的所有运算符
        while (!operatorStack.isEmpty()) {
            StdOut.print(operatorStack.pop());
        }
    }

    public static void main() {
        String expression = StdIn.readString();
        transform(expression);
    }
}
