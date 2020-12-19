package com.liubiao1.algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序：
 * 1、每次选无排序里最小的，比如第一趟选择最小的数据与数组的a[0]交换；
 * 2、第i趟选择第i小的数据与数组的a[i-1]交换；
 * 3、最后一趟是数组的长度减1
 * <p>
 * 排序过程如下，假设原始数组为  3 9 -1  8
 * <p>
 * 第1趟：
 * -1 9 3 8
 * 第2趟：
 * -1 3 9 8
 * 第3趟：
 * -1 3 8 9
 */
public class SelectionSort {
    public static void main(String[] args) {
//        int[] array = {3, 9, -1, 8};
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 50);
        }
        for (int j = 1; j < array.length; j++) {  // 每一趟
            int min = array[j - 1]; // 当前趟从这个值开始
            int s1 = j - 1; // 最小值所在的的下标值
            for (int i = j; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];  // 选出最小的
                    s1 = i;
                }
            }
            // 交换
            int temp = min;
            array[s1] = array[j - 1];
            array[j - 1] = temp;
        }
        Arrays.stream(array).forEach(System.out::println);
        System.out.println(Arrays.toString(array));
    }
}
