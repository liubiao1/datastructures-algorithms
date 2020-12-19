package com.liubiao1.algorithms.search;

import java.util.Arrays;

/**
 * 斐波那契查找算法（黄金分割算法）  黄金分割点 0.618
 * 1、前提是数组必须已经有序;
 * 2、花了大量代码得到k值，去
 *
 * 2、理解难度较大
 */
public class Fibonacci {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(fib(10)));
        int[] arr = {0, 3, 4, 5, 9, 999};
        System.out.println(fibSearch(arr, 88));
    }


    /**
     * 创造斐波那契数列
     *
     * @param length 斐波那契数组长度
     * @return 斐波那契数列
     */
    public static int[] fib(int length) {
        int[] fib = new int[length];
        if (length >= 1) {
            fib[0] = 1;
        }
        if (length >= 2) {
            fib[1] = 1;
        }
        if (length >= 3) {
            for (int i = 2; i < length; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    /**
     * @param arr 目标数组
     * @param key 目标值
     * @return 下标
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;  // 斐波那契分割数组的下标
        int mid = 0;
        int f[] = fib(10); // 得到数列
        // 得到k 的值（最关键部分）
        while (high > f[k] - 1) {  // 保证 斐波那契数列的下标值K
            k++;
        }
        // f[k] 的值可能比arr的长度大，所以需要重新构建数组，没有的用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 实际上想用 a[high]的值填充
        for (int i = high + 1; i < f[k]; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1; //得到关键性的mid
            if (key < temp[mid]) {  //向左查找
                high = mid - 1;
                // 全部元素 = 前面的元素 + 后边元素
                k--;
            } else if (key > temp[mid]) { //向右查找
                low = mid + 1;
                k -= 2;
            } else { // 返回小的
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

}
