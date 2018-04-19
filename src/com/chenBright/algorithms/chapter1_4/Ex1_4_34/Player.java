package com.chenBright.algorithms.chapter1_4.Ex1_4_34;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenbright on 2018/4/18.
 * https://www.cnblogs.com/ikesnowy/p/7467994.html
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

    public static int playGameB(Game game) {
        int low = 1;
        int high = game.max();
        boolean isRightSide = true;

        int result = game.guess(1);
        if (result == guessResult.equal) {
            return 1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentGuess = (low + high) - game.getLastGuess();

            result = game.guess(currentGuess);
            if (result == guessResult.equal) {
                return currentGuess;
            }
           else if (result == guessResult.hot) {
                if (isRightSide) {
                    low = mid;
                }
                else {
                    high = mid;
                }
            }
            else {
                if (isRightSide) {
                    high = mid;
                }
                else {
                    low = mid;
                }
            }
            isRightSide = !isRightSide;
            if (high - low <= 1) {
                break;
            }
        }

        if (game.guess(low) == guessResult.equal) {
            return low;
        }
        else if (game.guess(high) == guessResult.equal) {
            return high;
        }
        return -1;
    }

    public static void main() {
        Game game = new Game(1000);
        int result = playGameA(game);
        StdOut.println("（方案一）秘密数字为：" + result);
        game.restart();
        result = playGameB(game);
        StdOut.println("（方案二）秘密数字为：" + result);
    }
}
