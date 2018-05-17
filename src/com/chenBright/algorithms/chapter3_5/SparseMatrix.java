package com.chenBright.algorithms.chapter3_5;

public class SparseMatrix {
    private SparseVector[] rows; // 每行是一个 spare vector
    private int n; // n维方阵

    public SparseMatrix(int n) {
        this.n = n;
        rows = new SparseVector[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new SparseVector();
        }
    }

    public double get(int i, int j) {

        if (i < 0 || i >= n) {
            throw new IllegalArgumentException("Illegal index");
        }
        if (j < 0 || j >= n) {
            throw new IllegalArgumentException("Illegal index");
        }
        return rows[i].get(j);
    }

    public void put(int i, int j, double val) {
        if (i < 0 || i >= n) {
            throw new IllegalArgumentException("Illegal index");
        }
        if (j < 0 || j >= n) {
            throw new IllegalArgumentException("Illegal index");
        }
        rows[i].put(j, val);
    }

    public SparseMatrix plus(SparseMatrix that) {
        if (this.n != that.n) {
            throw new RuntimeException("Dimensions disagree");
        }
        SparseMatrix matrix = new SparseMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = this.rows[i].get(j) + that.rows[i].get(j);
                if (sum != 0) {
                    matrix.put(i, j, sum);
                }
            }
        }
        return matrix;
    }

    public SparseVector times(SparseVector that) {
        if (n != that.size()) {
            throw new RuntimeException("Dimensions disagree");
        }
        SparseVector vector = new SparseVector();
        for (int i = 0; i < n; i++) {
            vector.put(i, this.rows[i].dot(that));
        }
        return vector;
    }

    public SparseMatrix times(SparseMatrix that) {
        if (this.n != that.n) {
            throw new RuntimeException("Dimensions disagree");
        }
        SparseMatrix matrix = new SparseMatrix(n);
        SparseVector[] thatLines = new SparseVector[n];
        for (int i = 0; i < n; i++) {
            thatLines[i] = new SparseVector();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double val = that.get(i, j);
                if (val != 0) {
                    thatLines[j].put(i, val);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = rows[i].dot(thatLines[j]);
                if (sum != 0) {
                    matrix.put(i, j, sum);
                }
            }
        }
        return matrix;
    }
}
