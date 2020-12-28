package com.liubiao1.leetcode.array;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mc0710
 */
public class Solution188 {
    private static int k = 10;
    private static int[] g = {2, 4, 1};
    private static int[] g1 = {3, 2, 6, 5, 0, 3};

    /**
     * 解题思路：每天都交易，将血赚的交易存到map里，key为第几天买的，value为血赚多少
     *
     * @param k      允许买卖次数
     * @param prices 每天的交易价格数组
     * @return 最多血赚多少
     */
    public static int maxProfit(int k, int[] prices) {
        Map<Integer, Integer> map = new TreeMap<>();
        int result = 0;
        if (prices.length <= 1) {
            return result;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                map.put(i - 1, prices[i] - prices[i - 1]);
            }
        }
//        if (k >= map.size()) {
//            result = map.values().stream().mapToInt((x, y) -> x + y).sum();
//        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(k, g));
        System.out.println(maxProfit(k, g1));
    }

}
