package com.liubiao1.leetcode.array;

//给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都
//可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
//
// 示例 1:
//
// 输入: nums = [1,3], n = 6
//输出: 1
//解释:
//根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
//现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
//其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
//所以我们最少需要添加一个数字。
//
// 示例 2:
//
// 输入: nums = [1,5,10], n = 20
//输出: 2
//解释: 我们需要添加 [2, 4]。
//
//
// 示例 3:
//
// 输入: nums = [1,2,2], n = 5
//输出: 0
//
// Related Topics 贪心算法
// 👍 225 👎 0
public class Solution330T {
    private static int[] nums1 = {1, 5, 10};
    private static int n1 = 20;

    /**
     * 参考题解：
     * <p>
     * 核心逻辑：[0,x) 的若干个数加上 k，可扩大值域至 [0,x+k)，注意 k∈[0,x]。
     * 将 k 视为 nums已有的数 或者 要插入的数
     * 根据题意，nums 必须有 1
     * 显然从 [0,1) 开始模拟扩展，一般地，我们取 k 最大，也就是 k = x
     * 假设 nums 空，我们这样模拟 [0,1) -> [0,2) -> [0,4) -> [0,8) ----> [0,y)，直到 y > n
     * 因此当 nums(i) ∈ [0,y] 时，可取之为 k 并扩大值域， 否则视为插入一个数 y。
     * <p>
     * 作者：francissoft
     * 链接：https://leetcode-cn.com/problems/patching-array/solution/cjava-jian-dan-qing-xi-de-si-lu-by-franc-1z4j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int minPatches(int[] nums, int n) {
        // 最大值域
        long maxi = 1;

        int result = 0;
        int i = 0;
        while (maxi <= n) {
            if (i<nums.length &&nums[i] < maxi) {

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minPatches(nums1, n1));
    }

}
