package com.liubiao1.algorithms.search;

/**
 * 插值查找算法： 二分查找的升级版了，  二分永远是对半，插值可以自适应  (代码实现和二分查找类似)
 * 1、数组必须已有序
 * 2、适合数组值比较连续的，大量的数；  分布值差距比较大的，不一定比二分优越
 * 3、就是mid求值的变化才让该算法能够做到自适应：  left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
 */
public class InsertValue {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        int resIndex = insertValue(arr, 0, arr.length - 1, 2);
        System.out.println(resIndex);
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
    public static int insertValue(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        // mid 公式 （这是它比2分查找优越的地方，自适应）
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int minVal = arr[mid];
        if (minVal < value) {
            return insertValue(arr, value, mid + 1, right);
        } else if (minVal > value) {
            return insertValue(arr, value, left, mid - 1);
        } else {
            return mid;
        }
    }
}
