package com.liubiao1.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mc0710
 */
public class Solution387 {

    private static String a = "leetcode";

    private static String b = "loveleetcode";

    public static int firstUniqChar(String s) {
        // key是字符串，value是字符串下标，如果重复就将value变为-1
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            map.put(s1, map.get(s1) == null ? i : -1);
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            if (map.get(s1) >= 0) {
                result = map.get(s1);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar(a));
        System.out.println(firstUniqChar(b));
    }

}
