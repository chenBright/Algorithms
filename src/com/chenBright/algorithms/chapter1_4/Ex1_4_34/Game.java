package com.chenBright.algorithms.chapter1_4.Ex1_4_34;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by chenbright on 2018/4/18.
 */

// 某次猜测的结果。
class GuessResult
{
    public int hot = 1;        // 比上次猜测更接近目标。
    public int equal = 0;     // 猜中目标。
    public int cold = -1;      // 比上次猜测更远离目标。
    public int firstGuess = -2; // 第一次猜测。
}

public class Game {
    private int range; // 目标值的最大范围
    private int secretNumber; // 目标值
    private int lastGuess; // 上次猜测的值
    private GuessResult guessResult; // 猜测结果



    public Game(int N) {
       range = N;
       secretNumber = StdRandom.uniform(1, N);
       lastGuess = -1;
       guessResult = new GuessResult();
    }

    public int guess(int guessNumber) {
        if (guessNumber == secretNumber) {
            return guessResult.equal;
        }
        if (lastGuess == -1) {
            lastGuess = guessNumber;
            return guessResult.firstGuess;
        }

        int lastDiff = Math.abs(lastGuess - secretNumber);
        lastGuess = guessNumber;
        int currentDiff = Math.abs(guessNumber - secretNumber);

        if (currentDiff < lastDiff) {
            return guessResult.hot;
        }
        else {
            return guessResult.cold;
        }
    }

    public void restart() {
        lastGuess = -1;
    }

    public int max() {
        return range;
    }

    public int getLastGuess() {
        return lastGuess;
    }
}
