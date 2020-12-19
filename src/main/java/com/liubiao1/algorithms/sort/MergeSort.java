package com.liubiao1.algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序：  分而治之，和fork-join类似   ，时间复杂度相对低 ，因为合并的次数是数组长度减1 O(nlogn）
 * 1、把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2、对这两个子序列分别采用归并排序；
 * 3、将两个排序好的子序列合并成一个最终的排序序列
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 0, 4, 6, 5};
        int[] temp = new int[array.length];
        int mid = array.length / 2;
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }


    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左 分解
            mergeSort(arr, left, mid, temp);
            // 右 分解
            mergeSort(arr, mid + 1, right, temp);
            /****************         每分解一次就合并一次       *******/
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并
     *
     * @param arr   待排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的初始索引
     * @param temp  中转数组，额外的内存空间
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // temp的位置指针，来表明当前的位置
        int t = 0;
        int i = left; //左边索引
        int j = mid + 1; //右边索引;
        // 第一步：先把左右两边的有序数据 按照规则填充到 temp,直到有一边填充完成
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 第二步：将没有完成填充的那边剩余的数据复制到temp
        while (i <= mid) {      // 左边剩余
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {    // 右边剩余
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 第三步：将temp数组的元素全部拷贝到arr
        t = 0;
        int tempLeft = left;
        /********************* 这块有点难想* ***********************************/
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
