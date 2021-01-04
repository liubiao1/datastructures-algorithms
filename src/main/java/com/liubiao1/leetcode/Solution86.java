package com.liubiao1.leetcode;
//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
//
//
// 示例：
//
//
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
//
// Related Topics 链表 双指针
// 👍 346 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author mc0710
 */

public class Solution86 {

    /**
     * 解题思路： 比标量值小的放一个链表，大于等于的放一个链表，最后遍历组合
     *
     * @param head 目标list
     * @param x    标量值
     * @return 根据标量值排序后
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        int val;
        while (head != null) {
            val = head.val;
            if (x > val) {
                small.add(val);
            } else {
                big.add(val);
            }
            head = head.next;
        }
        small.addAll(big);
        ListNode result = new ListNode(small.get(0));
        ListNode last = result;
        for (int i = 1; i < small.size(); i++) {
            ListNode next = new ListNode(small.get(i));
            last.next = next;
            last = next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        partition(listNode, 3);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
