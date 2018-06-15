package com.chenBright.algorithms.chapter5_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GREP {
    public static void main() {
        StdOut.print("请输入模式字符串：");
        String regexp =  StdIn.readString();
        regexp = "(.*" + regexp + ".*)";
        NFA nfa = new NFA(regexp);

        String filename = "./data/tinyL.txt";
        try {
            FileInputStream input = new FileInputStream(filename);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (StdIn.hasNextLine()) {
            String txt = StdIn.readLine();
            if (nfa.recognizes(txt)) {
                StdOut.println(txt);
            }
        }
    }
}
