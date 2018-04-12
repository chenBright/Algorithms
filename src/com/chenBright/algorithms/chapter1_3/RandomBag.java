package com.chenBright.algorithms.chapter1_3;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by chenbright on 2018/4/12.
 * 随机背包
 */
public class RandomBag<Item> implements Iterable<Item> {
    private Item[] bag;
    private int number;

    public RandomBag(int maxSize) {
        bag = (Item[]) new Object[maxSize];
        number = 0;
    }

   public boolean isEmpty() {
        return number == 0;
   }

   public int size() {
        return number;
   }

   public void add(Item item) {
        if (number == bag.length) {
            resize(2 * bag.length);
        }
        bag[number++] = item;
   }

   private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < number; i++) {
            temp[i] = bag[i];
        }
        bag = temp;
   }

   public Iterator<Item> iterator() {
        return new RandomBagIterator();
   }

    private class RandomBagIterator implements Iterator<Item> {
        private int seq[] = new int[number];
        private int index = 0;

        public RandomBagIterator() {
            for (int i = 0; i < seq.length; i++)
                seq[i] = i;
            StdRandom.shuffle(seq);
        }

        @Override
        public boolean hasNext() {
            return index <= number;
        }

        @Override
        public Item next() {
            return bag[seq[index++]];
        }

        @Override
        public void remove() {}
    }
}
