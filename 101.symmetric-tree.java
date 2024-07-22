/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 使用队列，两两入队，出队
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        if ((root == null) || left == null && right == null) {
            return true;
        }

        q.add(left);
        q.add(right);

        while (!q.isEmpty()) {
            left = q.poll();
            right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || left.val != right.val){
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;

        // 调用递归方法
        // return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;

        if (a == null || b == null) return false;

        return (a.val == b .val) && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
// @lc code=end

