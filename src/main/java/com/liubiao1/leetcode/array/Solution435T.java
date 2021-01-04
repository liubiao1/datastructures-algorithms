package com.liubiao1.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * //给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * //
 * // 注意:
 * //
 * //
 * // 可以认为区间的终点总是大于它的起点。
 * // 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * //
 * //输出: 1
 * //
 * //解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: [ [1,2], [1,2], [1,2] ]
 * //
 * //输出: 2
 * //
 * //解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * //
 * //
 * // 示例 3:
 * //
 * //
 * //输入: [ [1,2], [2,3] ]
 * //
 * //输出: 0
 * //
 * //解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * //
 * // Related Topics 贪心算法
 * // 👍 299 👎 0
 *
 * @author mc0710
 */
public class Solution435T {

    private static int[][] a = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

    /**
     * 解题思路：    1、遍历二维数组；
     * 2、扩充后的区间用双向队列存储
     * 3、区间扩充：当新区间的左数值大于等于扩充后的区间右数值，直接从尾部插入；当心区间的右数值小于等于扩充后的区间值，直接头插入
     * 4、完全包含的区间时，留小区间
     *
     * @param intervals 目标二维数组
     * @return 需要移除的数组最小个数
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        // 扩充后的区间
        Deque<Integer> deque = new LinkedList<>();
        // 遍历二维数组
        for (int[] arr : intervals) {
            // 如果是空的，直接入队列
            if (null == deque.pollFirst()) {
                deque.offerFirst(arr[1]);
                deque.offerFirst(arr[0]);
                break;
            }
            // deque中最小的大于等于数组右值
            Integer integer1 = deque.pollFirst();
            if (integer1 >= arr[1]) {
                deque.offerFirst(integer1);
                deque.offerFirst(arr[1]);
                deque.offerFirst(arr[0]);
                break;
            }
            // deque中最大的小于等于数组右值
            Integer integer2 = deque.pollLast();
            if (integer2 <= arr[0]) {
                deque.offerLast(integer2);
                deque.offerLast(arr[0]);
                deque.offerLast(arr[1]);
                break;
            }


        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(a));

        TreeMap<Integer, Integer> objectObjectTreeMap = new TreeMap<>();
        objectObjectTreeMap.put(1,2);
        objectObjectTreeMap.put(2,1);
        objectObjectTreeMap.put(100,10);
        objectObjectTreeMap.put(20,90);
    }
}
