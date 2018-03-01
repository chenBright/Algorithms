package com.chenBright.algorithms;

import com.chenBright.algorithms.chapter1_1.*;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/2/28.
 */
public class Exercise {

    /*
    例如习题 1.1.1，chapter = 1，section = 1，question = 1
     */
    int chapter; // 章
    int section; // 节
    int question; // 题序号

    public Exercise(int chapter, int section, int question) {
        this.chapter = chapter;
        this.section = section;
        this.question = question;
    }

    public void chooseQuestion() {
        switch (this.chapter) {
            case 1:
                chapter1(this.section, this.question);
                break;
            default:
                StdOut.printf("没有第 %d 章的答案！", this.chapter);
        }
    }

    private static void chapter1(int section, int question) {
        switch (section) {
            case 1:
                section1(question);
                break;
            default:
                StdOut.printf("没有第 %d 节的答案！", section);
        }
    }

    private static void section1(int question) {
        switch (question) {
            case 1:
                Ex1_1_1.main();
                break;
            case 2:
                Ex1_1_2.main();
                break;
            case 3:
                Ex1_1_3.main();
                break;
            case 5:
                Ex1_1_5.main();
                break;
            case 6:
                Ex1_1_6.main();
                break;
            case 9:
                Ex1_1_9.main();
                break;
            case 11:
                Ex1_1_11.main();
                break;
            case 13:
                Ex1_1_13.main();
                break;
            case 14:
                Ex1_1_14.main();
                break;
            case 15:
                Ex1_1_15.main();
                break;
            default:
                StdOut.printf("没有第 %d 题的答案！", question);
        }
    }
}
