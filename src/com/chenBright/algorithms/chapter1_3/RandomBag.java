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

    /**
     * 背包是否为空
     * @return true / false
     */
   public boolean isEmpty() {
        return number == 0;
   }

    /**
     * 背包中元素数量
     * @return 数量
     */
   public int size() {
        return number;
   }

    /**
     * 添加元素
     * @param item 元素
     */
   public void add(Item item) {
        if (number == bag.length) {
            resize(2 * bag.length);
        }
        bag[number++] = item;
   }

    /**
     * 调整数组大小
     * @param max 数组长度
     */
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
        private int seq[] = new int[number]; // 包含迭代时索引值的数组
        private int index = 0;

        public RandomBagIterator() {
            for (int i = 0; i < seq.length; i++) {
                seq[i] = i;
            }
            // 打乱数组，达到随机访问的目的
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
