package com.chenBright.algorithms.chapter3_1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FrequencyCounter {
    public static void main() {
        StdOut.print("请输入最小键长：");
        int minLen = StdIn.readInt();
        ST<String, Integer> st = new ST<String, Integer>();
        String[] fileNames = {"./data/tinytinyTale.txt", "./data/tinyTale.txt", "./data/tale.txt"};
        try {
            FileInputStream input = new FileInputStream("./data/tinyTale.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (!StdIn.isEmpty()) {
            // 构造符号表并统计频率
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;
            }
            if (!st.contains(word)) {
                st.put(word, 1);
            }
            else {
                st.put(word, st.get(word) + 1);
            }
        }

        // 找到出现频率最高的单词
        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
