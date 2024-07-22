/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return calcDepth(root) != -1;
    }

    // 递归计算左右子树深度
    // 并且判断当前树是否平衡，用-1标识非平衡
    // 如果有子树不平衡那这个树肯定也不平衡
    private int calcDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftD = calcDepth(root.left);
        int rightD = calcDepth(root.right);
        if (leftD == -1 || rightD == -1 || Math.abs(leftD - rightD) > 1) {
            return -1;
        }
        return Math.max(leftD, rightD) + 1;
    }
}
// @lc code=end

