package com.chenBright.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/3/16.
 */
public class Rational
{
    private long numerator;
    private long denominator;

    public Rational(int numerator, int denominator)
    {
        this((long)numerator, (long)denominator);
    }

    private Rational(long numerator, long denominator)
    {
        if (denominator == 0)
            throw new RuntimeException("Denominator cannot be zero.");

        if (denominator < 0)
        {
            numerator = -numerator;
            denominator = -denominator;
        }

        long g = gcd(Math.abs(numerator), denominator);

        this.numerator = numerator / g;
        this.denominator = denominator / g;

        if (Math.abs(this.numerator) > Integer.MAX_VALUE ||
                Math.abs(this.denominator) > Integer.MAX_VALUE)
            throw new RuntimeException("Overflow error.");
    }

    public Rational(int n)
    {
        this.numerator = n;
        this.denominator = 1;
    }

    public int numerator()
    {
        return (int)numerator;
    }

    public int denominator()
    {
        return (int)denominator;
    }

    public Rational plus(Rational b)
    {
        return new Rational(this.numerator * b.denominator + b.numerator * this.denominator,
                this.denominator * b.denominator);
    }

    public Rational minus(Rational b)
    {
        return new Rational(this.numerator * b.denominator - b.numerator * this.denominator,
                this.denominator * b.denominator);
    }

    public Rational times(Rational b)
    {
        return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
    }

    public Rational divides(Rational b)
    {
        return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
    }

    public Rational neg()
    {
        return new Rational(-numerator, denominator);
    }

    public Rational inverse()
    {
        return new Rational(denominator, numerator);
    }

    public static Rational zero()
    {
        return new Rational(0, 1);
    }

    public boolean equals(Object x) {
        if (x == this) return true;
        if (x == null) return false;
        if (x.getClass() != this.getClass()) return false;
        Rational that = (Rational) x;
        return (this.numerator == that.numerator) && (this.denominator == that.denominator);
    }

    public String toString()
    {
        return numerator + "/" + denominator;
    }

    public double toDouble()
    {
        return ((double)numerator) / denominator;
    }

    private static long gcd(long p, long q)
    {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    public static void main()
    {
        StdOut.println(new Rational(12, 28));
        StdOut.println(new Rational(12, 28).neg());
        StdOut.println(new Rational(12, 28).inverse());
        StdOut.println();

        StdOut.println(new Rational(-12, 28));
        StdOut.println(new Rational(12, -28));
        StdOut.println(new Rational(-12, -28));
        StdOut.println();

        StdOut.println(new Rational(5));
        StdOut.println(Rational.zero());
        StdOut.println();

        StdOut.println(new Rational(2, 3).toDouble());
        StdOut.println(new Rational(12, 28).numerator());
        StdOut.println(new Rational(12, 28).denominator());
        StdOut.println();

        Rational r1 = new Rational(2, 3),
                r2 = new Rational(4, 7);

        StdOut.printf("%s + %s = %s (%s)\n", r1, r2, r1.plus(r2),
                r1.plus(r2).equals(new Rational(26, 21)));

        StdOut.printf("%s - %s = %s (%s)\n", r1, r2, r1.minus(r2),
                r1.minus(r2).equals(new Rational(2, 21)));

        StdOut.printf("%s * %s = %s (%s)\n", r1, r2, r1.times(r2),
                r1.times(r2).equals(new Rational(8, 21)));

        StdOut.printf("%s / %s = %s (%s)\n", r1, r2, r1.divides(r2),
                r1.divides(r2).equals(new Rational(7, 6)));
        StdOut.println();

        r1 = new Rational(Integer.MAX_VALUE, 10);

        r2 = new Rational(5, 17);
        StdOut.printf("%s * %s = %s\n", r1, r2, r1.times(r2));

        r2 = new Rational(101, 13);
        //StdOut.printf("%s * %s = %s\n", r1, r2, r1.times(r2));

        r1 = new Rational(Integer.MAX_VALUE, Integer.MAX_VALUE - 1);
        r2 = r1.inverse();
        //StdOut.printf("%s + %s = %s\n", r1, r2, r1.plus(r2));
    }
}