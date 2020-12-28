package com.liubiao1.leetcode.array;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 *  
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 * 通过次数86,570提交次数150,273
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mc0710
 */
public class Solution455 {

    private static int[] g = {1, 2, 3}, s = {1, 1};

    private static int[] g1 = {1, 2}, s1 = {1, 2, 3};

    private static int[] g2 = {10, 9, 8, 7}, s2 = {5, 6, 7, 8};

    /**
     * 排序后加双指针
     *
     * @param g 小孩儿胃口数组
     * @param s 饼干数组
     * @return 最大满足多少小孩数
     */
    public static int findContentChildren(int[] g, int[] s) {
        int result = 0;
        // 胃口指针
        int i = 0;
        Arrays.sort(g);
        // 饼干指针
        int j = 0;
        Arrays.sort(s);
        for (; i < g.length; i++) {
            if (j >= s.length) {
                break;
            }
            if (g[i] <= s[j]) {
                result++;
                j++;
            } else {
                j++;
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(g, s));
        System.out.println(findContentChildren(g1, s1));
        System.out.println(findContentChildren(g2, s2));
    }

}
