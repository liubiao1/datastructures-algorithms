package com.liubiao1.algorithms.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 插入排序：  时间复杂度也是 n * n
 * 1、将带排序数据分为有序区和无序区；
 * 2、每次将待排序数放到有序区的合适位置
 * <p>
 * 排序过程如下，假设原始数组为  3 9 -1  8
 * <p>
 * 第1趟：
 * 3 9 -1 8
 * 第2趟：
 * -1 3 9 8
 * 第3趟：
 * -1 3 8 9
 * <p>
 * shift + F6 ： 批量更改变量值
 */
public class InsertionSort {
    public static void main(String[] args) {
//        int[] array = {3, 9, -1, 8};
        int[] array = new int[20000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 500000);
        }
        int insertIndex, insertVal;  //定义要插入的索引 和要插入的值
        int begin = LocalDateTime.now().getNano();
        for (int i = 1; i < array.length; i++) {  // 第几趟
            insertIndex = i - 1; // 先和待插入值最近的一个值比
            insertVal = array[i];
            while (insertIndex >= 0 && array[insertIndex] > insertVal) {  // 如果待插入的值比 比较值小，证明还没要找到它合适的位置，需要将当前比较的值往后移
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;  // 取新的比较值，当前比较值的前一个
            }
            array[insertIndex + 1] = insertVal;  // 如果待插入的值比比较值大，证明找到了合适的位置
        }
        int end = LocalDateTime.now().getNano();
        System.out.println("总共花了" + (end - begin) + "纳秒");
//        System.out.println(Arrays.toString(array));
    }
}
