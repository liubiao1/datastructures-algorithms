package com.liubiao1.algorithms.search;

/**
 * 线性查找
 */
public class Seq {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 8};
    }

    public static int seq(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
