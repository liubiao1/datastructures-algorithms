package com.liubiao1.leetcode.array;

//在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
//
// 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
//
// 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示
//为 [3,6] 。
//
// 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
//
// 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
//
//
//
// 示例 1：
//
//
//输入：s = "abbxxxxzzy"
//输出：[[3,6]]
//解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
//
//
// 示例 2：
//
//
//输入：s = "abc"
//输出：[]
//解释："a","b" 和 "c" 均不是符合要求的较大分组。
//
//
// 示例 3：
//
//
//输入：s = "abcdddeeeeaabbbcd"
//输出：[[3,5],[6,9],[12,14]]
//解释：较大分组为 "ddd", "eeee" 和 "bbb"
//
// 示例 4：
//
//
//输入：s = "aba"
//输出：[]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅含小写英文字母
//
// Related Topics 数组
// 👍 85 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mc0710
 */
public class Solution830 {


    /**
     * 解题思路：双指针，开始指针和结束指针。结束指针减开始指针大于等于2的为较大分组
     *
     * @param s 指定字符串
     * @return 较大分组的位置
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        // val当前比较的值
        int begin = 0, end = 0, val = chars[0];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (val == chars[i]) {
                end++;
            } else {
                if (begin == 0 && end - begin > 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(begin);
                    list.add(end - 1);
                    result.add(list);
                }
                if (begin != 0 && end - begin >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(begin);
                    list.add(end);
                    result.add(list);
                }
                begin = end = i;
                val = chars[end];
            }
        }
        if (end == chars.length - 1 && end - begin >= 2) {
            List<Integer> list = new ArrayList<>();
            list.add(begin);
            list.add(end);
            result.add(list);
        }
        if (begin == 0 && end == chars.length && end - begin > 2) {
            List<Integer> list = new ArrayList<>();
            list.add(begin);
            list.add(end - 1);
            result.add(list);
        }
        return result;
    }

    /**
     * 官方思路：1、遍历该序列，并记录当前分组的长度；
     * 2、如果下一个字符与当前字符不同，或者已经枚举到字符串尾部，就说明当前字符为当前分组的尾部
     * 3、每次找到当前分组的尾部时，如果该分组长度达到 3，我们就将其加入答案
     *
     * @param s 指定字符串
     * @return 较大分组的位置
     */
    public static List<List<Integer>> official(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int length = s.length();
        // 每次分组长度
        int num = 1;
        for (int i = 0; i < length; i++) {
            if (i == length - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    result.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("aabbb"));
        System.out.println(largeGroupPositions("aaa"));
        System.out.println(largeGroupPositions("aaaa"));
        System.out.println(largeGroupPositions("abbxxxxzyy"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
