package com.liubiao1.algorithms.sort;

import java.util.Arrays;

/**
 * 基数排序： 桶排序的升级版
 * 1、趟数是取决于数组最大值的位置；
 * 2、需要额外的空间，且每个桶都是数组的最大值；数据量特别多的情况下，内存占用比较大，会报内存不足等错误，
 * 比如1千万长度的数组排序，大概需要  10000000 * 10 *4/1024/1024/1024 = 0.37G内存 (数组长度、桶数、int占字节)，所以1亿长度的数组就可能报错了
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 10, 4, 6, 5};
//        radixSortTest(array);
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    // 实现思路版
    public static void radixSortTest(int[] array) {
        // 定义桶： 极端情况数组都在一个桶里， 典型的空间换时间
        int[][] bucket = new int[10][array.length];
        // 记录每个桶中装入的元素,下标为0的就是0号桶内的数据
        int[] bucketElementCount = new int[10];

        // 第一轮，以个位数排序入桶
        for (int j = 0; j < array.length; j++) {
            // 取个位数
            int digits = array[j] % 10;
            // 放入对应桶中,把  bucketElementCount[digits] 当做0，下个+1，
            bucket[digits][bucketElementCount[digits]] = array[j];
            bucketElementCount[digits]++;
        }
        // 取出对应桶中的数据 放到原来数组中
        int index = 0;
        for (int k = 0; k < bucketElementCount.length; k++) {
            if (bucketElementCount[k] != 0) {
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    // 取出元素放到 arr中
                    array[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCount[k] = 0; /***注意点，每一轮过后要把桶内元素变为0,防止下一轮出问题**/
        }
        System.out.println("第一轮排序后结果：" + Arrays.toString(array));
        /*********************
         *  注意点，每一轮过后要把桶内元素变为0
         * ***********/

        // 第二轮，以十位数排序入桶
        for (int j = 0; j < array.length; j++) {
            // 取个位数
            int digits = array[j] / 10 % 10;
            // 放入对应桶中,把  bucketElementCount[digits] 当做0，下个+1，
            bucket[digits][bucketElementCount[digits]] = array[j];
            bucketElementCount[digits]++;
        }
        // 取出对应桶中的数据 放到原来数组中
        int index1 = 0;
        for (int k = 0; k < bucketElementCount.length; k++) {
            if (bucketElementCount[k] != 0) {
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    // 取出元素放到 arr中
                    array[index1] = bucket[k][l];
                    index1++;
                }
            }
            bucketElementCount[k] = 0; /***注意点，每一轮过后要把桶内元素变为0,防止下一轮出问题**/
        }
        System.out.println("第二轮排序后结果：" + Arrays.toString(array));
    }

    // 官方
    public static void radixSort(int[] array) {
        // 第一步，得到数组最大数的位数
        int max = array[0]; // 假定第一个就是最大的
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();  //  最大数的位数，决定有几趟
        // 定义桶： 极端情况数组都在一个桶里， 典型的空间换时间
        int[][] bucket = new int[10][array.length];
        // 记录每个桶中装入的元素,下标为0的就是0号桶内的数据
        int[] bucketElementCount = new int[10];
        for (int i = 0, count = 1; i < maxLength; i++, count *= 10) {
            for (int j = 0; j < array.length; j++) {
                // 取对应的位数
                int digits = array[j] / count % 10;
                // 放入对应桶中,把  bucketElementCount[digits] 当做0，下个+1，
                bucket[digits][bucketElementCount[digits]] = array[j];
                bucketElementCount[digits]++;
            }
            // 取出对应桶中的数据 放到原来数组中
            int index1 = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        // 取出元素放到 arr中
                        array[index1] = bucket[k][l];
                        index1++;
                    }
                }
                bucketElementCount[k] = 0; /***注意点，每一轮过后要把桶内元素变为0,防止下一轮出问题**/
            }
        }
    }
}
