package com.liubiao1.leetcode;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mc0710
 */
public class Solution135 {
    private static int[] a = {1, 0, 2};
    private static int[] b = {1, 2, 2};
    private static int[] c = {1, 0, 2, 3, 1};

    public static int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 1) {
            return 1;
        }
        // 初始糖果都为0
        int[] result = new int[length];
        int i = 0, j = length - 1;
        while (i < length - 1) {
            if (ratings[++i] > ratings[i - 1]) {
                result[i] = Math.max(result[i], result[i - 1] + 1);
            }
            if (ratings[--j] > ratings[j + 1]) {
                result[j] = Math.max(result[j], result[j + 1] + 1);
            }
        }
        return Arrays.stream(result).sum() + length;
    }

    public static void main(String[] args) {
        System.out.println(candy(a));
        System.out.println(candy(b));
        System.out.println(candy(c));
    }
}
