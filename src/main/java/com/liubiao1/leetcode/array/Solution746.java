package com.liubiao1.leetcode.array;

/**
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * <p>
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mc0710
 */
public class Solution746 {

    private static int[] arr1 = {10, 15, 20};
    private static int[] arr2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};


    /**
     * 时间复杂d度n,空间复杂度N，利用了result
     *
     * @param cost 花费值数组
     * @return 到楼顶最少体力花费
     */
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] result = new int[length + 1];
        result[0] = result[1] = 0;
        for (int i = 2; i <= length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }
        return result[length];
    }


    /**
     * 时间复杂d度n,空间复杂度1，(优化空间复杂度)
     *
     * @param cost 花费值数组
     * @return 到楼顶最少体力花费
     */
    public static int minCostClimbingStairsMajorization(int[] cost) {
        int length = cost.length;
        // a是result[i - 1] 的值，b是result[i - 2]的值
        int a = 0, b = 0;
        for (int i = 2; i <= length; i++) {
            int next = Math.min(b + cost[i - 1], a + cost[i - 2]);
            // 滚动数组
            a = b;
            b = next;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(arr1));
        System.out.println(minCostClimbingStairs(arr2));
        System.out.println(minCostClimbingStairsMajorization(arr1));
        System.out.println(minCostClimbingStairsMajorization(arr2));

    }


}
