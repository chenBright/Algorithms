package com.chenBright.algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {

        StdOut.print("第几章？ ");
        int chapter = StdIn.readInt();
        StdOut.print("第几节？ ");
        int section = StdIn.readInt();
        StdOut.print("第几题？ ");
        int question = StdIn.readInt();

        Exercise exercise = new Exercise(chapter, section, question);
        exercise.chooseQuestion();
    }
}
