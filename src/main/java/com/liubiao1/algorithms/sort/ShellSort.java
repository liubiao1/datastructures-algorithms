package com.liubiao1.algorithms.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 希尔排序：  插入排序的优化版，第一个突破时间复杂度为n * n 的排序算法
 * 1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2、按增量序列个数k，对序列进行k 趟排序；
 * 3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度
 * <p>
 * 排序过程如下，假设原始数组为  8, 9, 1, 7, 2, 3, 5, 4, 6, 0
 * <p>
 * 第1趟：  分10/2 = 5 组     83、95、14、76、20
 * 3 5 1 6 0 8 9 4 7 2
 * 第2趟：  分5/2 = 2 组    31097、 56842
 * 0 2 1 4 3 5 7 6 9 8
 * 第3趟：  分2/2 = 1 组    0 2 1 4 3 5 7 6 9 8
 * 0 1 2 3 4 5 6 7 8 9
 * <p>
 */
public class ShellSort {
    public static void main(String[] args) {
        /***********************************            自我研究版           ******************************/
/*        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        // 第一趟
        int group = array.length / 2;
        for (int i = 0; i < group; i++) {
            if (array[i] > array[i + group]) {
                int temp = array[i + group];
                array[i + group] = array[i];
                array[i] = temp;
            }
        }
        System.out.println("第一趟排序后的值为：" + Arrays.toString(array));*/

        //第二趟
/*        int[] array2 = {3, 5, 1, 6, 0, 8, 9, 4, 7, 2}; // 第一趟排序后的
        int group2 = array2.length / 2 / 2;
        for (int i = 0; i < group2; i++) {
            int insertIndex, insertValue;
            for (int j = 1; j < array2.length / group2; j++) {
                insertIndex = (j - 1) * group2 + i;
                insertValue = array2[j * group2 + i];
                while (insertIndex >= 0 && array2[insertIndex] > insertValue) {
                    array2[insertIndex + group2] = array2[insertIndex];
                    insertIndex -= group2;
                }
                array2[insertIndex + group2] = insertValue;
            }
        }
        System.out.println("第二趟排序后的值为：" + Arrays.toString(array2));*/

        // 第三趟 ，就是插入排序
/*        int[] array3 = {0, 2, 1, 4, 3, 5, 7, 6, 9, 8};
        for (int i = 1; i < array3.length; i++) {
            int insertIndex = i - 1;
            int insertValue = array3[i];
            while (insertIndex >= 0 && insertValue < array3[insertIndex]) {
                array3[i] = array3[insertIndex];
                insertIndex--;
            }
            array3[insertIndex + 1] = insertValue;
        }
        System.out.println("第二趟排序后的值为：" + Arrays.toString(array3));*/

        // 由上面代码可整合成如下
//        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        int[] array1 = array;
        int[] array2 = array;
        int ownBegin = LocalDateTime.now().getNano();
        int print = print(array, array.length / 2);
        while (print > 1) {
            print = print / 2;
            print(array, print);
        }
        int ownEnd = LocalDateTime.now().getNano();
        System.out.println("自我研究耗时：" + (ownEnd - ownBegin));


        /***********************************            标准版（交换式）           ******************************/
/*        //第一轮
        for (int i = 5; i < array.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (array[j] > array[j + 5]) {
                    int temp = array[j];
                    array[j] = array[j + 5];
                    array[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮：" + Arrays.toString(array));
        //第二轮
        for (int i = 2; i < array.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (array[j] > array[j + 2]) {
                    int temp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮：" + Arrays.toString(array));
        //第三轮
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮：" + Arrays.toString(array));*/

        // 网上标准
        int orderBegin = LocalDateTime.now().getNano();
        int[] orderArray = other(array1);
        int orderEnd = LocalDateTime.now().getNano();
        System.out.println("网上标准耗时：" + (orderEnd - orderBegin));
        System.out.println(Arrays.toString(orderArray));

        /***********************************            标准版（移位式）           ******************************/
        // 网上标准 (移位法)
        int order2Begin = LocalDateTime.now().getNano();
        int[] order2Array = other2(array2);
        int order2End = LocalDateTime.now().getNano();
        System.out.println("网上标准（移位式）耗时：" + (order2End - order2Begin));
        System.out.println(Arrays.toString(orderArray));

    }

    // 打印每趟执行后的数组结果
    private static int print(int[] array, int group) {
        for (int i = 0; i < group; i++) {
            int insertIndex, insertValue;
            for (int j = 1; j < array.length / group; j++) {
                insertIndex = (j - 1) * group + i;
                insertValue = array[j * group + i];
                while (insertIndex >= 0 && array[insertIndex] > insertValue) {
                    array[insertIndex + group] = array[insertIndex];
                    insertIndex -= group;
                }
                array[insertIndex + group] = insertValue;
            }
        }
        System.out.println(Arrays.toString(array));
        return group;
    }

    private static int[] other(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
        return array;
    }

    private static int[] other2(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {  // 这段就是用插入来进行移位的
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        // 移动
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    /** 测试结果，我的完爆交换式标准，为啥我这么N？？ **/

    /** 移位法的 希尔排序玩爆了我自己写的，难受啊 */

    /**   希尔排序要用就用   移动式 other2          ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！*/
}
