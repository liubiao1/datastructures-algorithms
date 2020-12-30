package com.liubiao1.leetcode.queue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * //有一堆石头，每块石头的重量都是正整数。
 * //
 * // 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * //
 * //
 * // 如果 x == y，那么两块石头都会被完全粉碎；
 * // 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * //
 * //
 * // 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：[2,7,4,1,8,1]
 * //输出：1
 * //解释：
 * //先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * //再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * //接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * //最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= stones.length <= 30
 * // 1 <= stones[i] <= 1000
 * //
 * // Related Topics 堆 贪心算法
 * // 👍 112 👎 0
 *
 * @author mc0710
 */
public class Solution1046 {

    private static int[] a = {2, 7, 4, 1, 8, 1};

    private static int[] b = {1, 3};

    private static int[] c = {3, 2, 5, 1, 6, 3, 10, 7, 10};

    // 2
    private static int[] d = {3, 7, 8};

    /**
     * 解题思路：按题目描述解题，用linkedList方便增删
     *
     * @param stones 石头堆
     * @return 剩下那块石头的重量。
     */
    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }
        // 倒序
        list.sort((o1, o2) -> o2 - o1);
        while (list.size() > 1) {
            // 碎石头
            int i1 = list.get(0) - list.get(1);
            // 粉碎了大石头
            list.remove(0);
            list.remove(0);
            if (list.size() == 0) {
                return i1;
            }
            if (i1 > 0) {
                boolean f = true;
                int i = 0;
                for (; i < list.size(); i++) {
                    if (i1 >= list.get(i)) {
                        list.add(i, i1);
                        f = false;
                        break;
                    }
                }
                if (i == list.size() && f) {
                    list.add(i1);
                }
            }
        }
        return list.get(0);
    }


    /**
     * 官方题解思路：数据结构，最大堆（没想到这数据结构）
     *
     * @param stones 石头堆
     * @return 剩下那块石头的重量。
     */
    public static int official(int[] stones) {
        // 定义最大堆，大的放前面
        PriorityQueue<Integer> integers = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            integers.offer(s);
        }
        while (integers.size() > 1) {
            // 每次取最大的2个，如果没有粉碎完全，将剩余渣子放回石头堆
            int a = integers.poll();
            int b = integers.poll();
            if (a > b) {
                integers.offer(a - b);
            }
        }
        return integers.isEmpty() ? 0 : integers.poll();
    }

    public static void main(String[] args) {
        System.out.println("——————————自解的————————");
        System.out.println(lastStoneWeight(a));
        System.out.println(lastStoneWeight(b));
        System.out.println(lastStoneWeight(c));
        System.out.println(lastStoneWeight(d));
        System.out.println("——————————官方的————————");
        System.out.println(official(a));
        System.out.println(official(b));
        System.out.println(official(c));
        System.out.println(official(d));
    }

}
