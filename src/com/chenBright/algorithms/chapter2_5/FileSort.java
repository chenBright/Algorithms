package com.chenBright.algorithms.chapter2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

public class FileSort {
    public static void main() {
        String str = StdIn.readString();
        File directory = new File(str);
        if (!directory.exists()) {
            StdOut.println(str + " does not exist");
            return;
        }
        if (!directory.isDirectory()) {
            StdOut.println(str + " is not a directory");
            return;
        }
        String[] files = directory.list();
        if (files == null) {
            StdOut.println("could not read files");
            return;
        }
        Arrays.sort(files);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
