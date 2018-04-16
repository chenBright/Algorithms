package com.chenBright.algorithms.chapter1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by chenbright on 2018/4/16.
 *
 * 算法过程类似于 “滑雪”，从数值较高的一侧向周围数值较小的一侧移动，直到到达“山谷”（局部最小）。
 * 首先在中间行搜索最小值，再将最小值与其上下两个元素比较，如果不满足题意，则“滑向”较小的一侧，矩阵被分为了两半（上下两侧）。
 * 在较小的一侧，找到中间列的最小值，再将最小值与其左右两个元素比较，如果不满足题意，类似的移动到较小的一侧（左右两侧）。
 * 现在查找范围缩小到了原来矩阵的四分之一，递归的进行上述操作，最后可以得到答案。
 * 每次查找最小值都是对行/列进行遍历，遍历耗时和 N 成正比。
 */
public class Ex1_4_19 {
    private class RowCol {
        public int row; // 行
        public int col; // 列

        /**
         * 构造函数
         * @param i 行
         * @param j 列
         */
        public RowCol(int i, int j) {
            row = i;
            col = j;
        }
    }

    /**
     * 在矩阵中间行查找局部最小
     * @param matrix 矩阵
     * @param rowStart 实际查找范围的行起始
     * @param rowLength 实际查找范围的行数
     * @param colStart 实际查找范围的列起始
     * @param colLength 实际查找范围的列数
     * @return 包含行列信息的对象
     */
    private RowCol localMinRow(int[][] matrix, int rowStart, int rowLength, int colStart, int colLength) {
        int min = Integer.MIN_VALUE;
        if (rowLength < 3) {
            return new RowCol(-1, -1);
        }

        int mid = rowStart + rowLength / 2;
        int minCol = 0;
        // 获取矩阵中间行最小值
        for (int i = 0; i < colLength; i++) {
            if (min > matrix[mid][colStart + i]) {
                min = matrix[mid][colStart + i];
                minCol = i;
            }
        }

        // 检查是否满足条件
        if (matrix[mid][minCol] < matrix[mid - 1][minCol] && matrix[mid][minCol] < matrix[mid + 1][minCol]) {
            return new RowCol(mid, minCol);
        }

        // 向一侧移动
        if (matrix[mid][minCol] > matrix[mid - 1][minCol]) {
            return localMinCol(matrix, rowStart, rowLength / 2 + 1, colStart, colLength);
        }
        else {
            return localMinCol(matrix, mid + 1, rowLength / 2 + 1, colStart, colLength);
        }
    }

    /**
     * 在矩阵中间行查找局部最小
     * @param matrix 矩阵
     * @param rowStart 实际查找范围的行起始
     * @param rowLength 实际查找范围的行数
     * @param colStart 实际查找范围的列起始
     * @param colLength 实际查找范围的列数
     * @return 包含行列信息的对象
     */
    private RowCol localMinCol(int[][] matrix, int rowStart, int rowLength, int colStart, int colLength) {
        int min = Integer.MAX_VALUE;
        if (colLength < 3) {
            return new RowCol(-1, -1);
        }

        int mid = colStart + colLength / 2;
        int minRow = 0;
        // 获取矩阵中间列的最小值
        for (int i = 0; i < rowLength; i++) {
            if (min > matrix[rowStart + i][mid]) {
                min = matrix[rowStart + i][mid];
                minRow = i;
            }
        }

        // 检查是否满足条件
        if (matrix[minRow][mid] < matrix[minRow][mid - 1] && matrix[minRow][mid] < matrix[minRow][mid + 1]) {
            return new RowCol(minRow, mid);
        }

        // 向一侧移动
        if (matrix[minRow][mid] > matrix[minRow][mid - 1]) {
            return localMinRow(matrix, rowStart, rowLength, colStart, colLength / 2 + 1);
        }
        else {
            return localMinRow(matrix, rowStart,rowLength, mid + 1, colLength / 2 + 1);
        }
    }

    public void main() {
        int[][] matrix = {
                { 26, 3, 4 , 10, 11 },
                { 5, 1, 6, 12, 13 },
                { 7, 8, 9 , 14, 15 },
                { 16, 17, 18, 27, 20 },
                { 21, 22, 23, 24, 25 }
        };
        RowCol rowCol = localMinRow(matrix, 0, 5, 0, 5);
        StdOut.printf("局部最小值的行：%d， 列：%d\n", rowCol.row, rowCol.col);
    }
}
