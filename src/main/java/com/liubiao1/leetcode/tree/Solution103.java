package com.liubiao1.leetcode.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mc0710
 */
public class Solution103 {

    private static TreeNode root = new TreeNode(3);

    public Solution103() {
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        // 是否从左往右
        boolean isLeft = true;
        while (!treeNodes.isEmpty()) {
            // 因为是锯齿形层序遍历，要分奇偶，奇数层从左到右，偶数层从右到左，所以用双向队列存储输出值
            Deque<Integer> integers = new LinkedList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = treeNodes.poll();
                if (isLeft) {
                    // 从左到右时，从后面开始插，因为先插入的就在最左边
                    integers.offerLast(curNode.val);
                } else {
                    integers.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    treeNodes.offer(curNode.left);
                }
                if (curNode.right != null) {
                    treeNodes.offer(curNode.right);
                }
            }
            result.add(new LinkedList<>(integers));
            isLeft = !isLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        // 参考官方解题
        new Solution103();
        System.out.println(zigzagLevelOrder(root));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
