package com.liubiao1.algorithms.search;

import java.util.ArrayList;

/**
 * 二分查找
 * 1、前提是数组必须已经有序;(这点很容易忘记)
 * 2、凡是递归，一定要注意死循环的问题
 */
public class Binary {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
//        int resIndex = binary(arr, 10, 0, arr.length - 1);
//        System.out.println(resIndex);
        ArrayList<Integer> indexs = binaryMore(arr, 9, 0, arr.length - 1);
        indexs.stream().forEach(System.out::println);
    }

    /**
     * 返回数组下标
     *
     * @param arr   原始数组
     * @param value 查找的值
     * @param left  左指针
     * @param right 右
     * @return
     */
    public static int binary(int[] arr, int value, int left, int right) {
        if (left > right) {  // 跳出循环的条件
            return -1;
        }
        int mid = (left + right) / 2;
        int minVal = arr[mid];
        if (minVal < value) {
            return binary(arr, value, mid + 1, right);
        } else if (minVal > value) {
            return binary(arr, value, left, mid - 1);
        } else {
            return mid;
        }
    }

    /**
     * 升级版，
     * 问题： 如果数组里的值有多个一样的，我找的就是这个值；我想要得到这个值的所有下标返回，比如9
     */
    public static ArrayList<Integer> binaryMore(int[] arr, int value, int left, int right) {
        if (left > right) {  // 跳出循环的条件
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int minVal = arr[mid];
        if (minVal < value) {
            return binaryMore(arr, value, mid + 1, right);
        } else if (minVal > value) {
            return binaryMore(arr, value, left, mid - 1);
        } else {
            ArrayList<Integer> indexs = new ArrayList<Integer>();
            // 左扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                indexs.add(temp);
                temp--;
            }
            indexs.add(mid);  // mid本身就是找到的那个，不能忘加
            // 右扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                indexs.add(temp);
                temp++;
            }
            return indexs;
        }
    }
}
