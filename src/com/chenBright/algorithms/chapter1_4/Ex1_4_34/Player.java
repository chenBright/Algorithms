package com.chenBright.algorithms.chapter1_4.Ex1_4_34;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/18.
 */
public class Player {
    private static GuessResult guessResult = new GuessResult();

    public static int playGameA(Game game) {
        int low = 1;
        int high = game.max();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = game.guess(low);
            if (result == guessResult.equal) {
                return low;
            }

            result = game.guess(high);
            if (result == guessResult.equal) {
                return high;
            }
            else if (result == guessResult.cold) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        return -1;
    }

    public static void main() {
        Game game = new Game(1000);
        int result = playGameA(game);
        StdOut.println("秘密数字为：" + result);
    }
}
