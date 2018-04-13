package com.chenBright.algorithms.chapter1_3;

import java.util.Random;

/**
 * Created by chenbright on 2018/4/13.
 * 随机队列
 */
public class RandomQueue<Item> {
    private Item[] queue;
    private int number;

    public RandomQueue(int maxSize) {
        queue = (Item[]) new Object[maxSize];
        number = 0;
    }

    /**
     * 背包是否为空
     * @return true / false
     */
    public boolean isEmpty(){
        return number == 0;
    }

    /**
     * 入队
     * @param item 入队元素
     */
    public void enqueue(Item item) {
        queue[number++] = item;
    }

    /**
     * 随机出队
     * @return 出队元素
     */
    public Item dequeque() {
        int dequequeIndex = getRandomIndex();
        Item dequequeItem = queue[dequequeIndex];
        Item temp = queue[number - 1];
        queue[number - 1] = dequequeItem;
        queue[dequequeIndex] = temp;

        queue[number - 1] = null;
        number--;

        return dequequeItem;
    }

    /**
     * 随机访问元素
     * @return 被访问的元素
     */
    public Item sample() {
        int sampleIndex = getRandomIndex();
        return queue[sampleIndex];
    }

    /**
     * 调整数组大小
     * @param max 数组长度
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < number; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    /**
     * 随机获取被访问元素的索引值
     * @return 索引值
     */
    private int getRandomIndex() {
        Random rand = new Random();
        int itemIndex = rand.nextInt(number - 1);
        return itemIndex;
    }


}
