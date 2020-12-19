package com.liubiao1.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序：冒泡的优化版      快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）
 * 1、从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * <p>
 * 排序过程如下，假设原始数组为  8, 9, 1, 7, 2, 3, 0, 4, 6, 5
 * <p>
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 0, 4, 6, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int left, int right) {
        // 第一步，把比基准小的值都放在左边，大的值都放在右边
        int pivot = array[(left + right) / 2]; //基准
        int l = left;
        int r = right;
        int temp;
        while (l < r) {
            // 在基准左边一直找，直到找到比基准大的为止
            while (array[l] < pivot) {
                l += 1;
            }
            while (array[r] > pivot) {
                r -= 1;
            }
            // 找完了
            if (l >= r) {
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if (array[l] == pivot) {
                r -= 1;
            }
            if (array[r] == pivot) {
                l += 1;
            }

        }
        if (l == r) {  //这个必须得有，不然会StackOverflowError， 吧r 和l错开
            l += 1;
            r -= 1;
        }
        // 第二步，向左递归
        if (left < r) {
            quickSort(array, left, r);
        }
        // 第三步，向右递归
        if (right > l) {
            quickSort(array, l, right);
        }


    }
}
