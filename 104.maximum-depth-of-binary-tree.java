/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        // 递归
        // if (root == null) {
        //     return 0;
        // }
        // return (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);

        // 循环迭代，使用队列
        // 每次把当前层的节点都出队
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int treeDepth = 0;

        while (!q.isEmpty()) {
            int currNum = q.size();
            for (int i = 0; i< currNum; i++) {
                TreeNode r = q.poll();
                if (r.left != null) {
                    q.add(r.left);
                }
                if (r.right != null) {
                    q.add(r.right);
                }
            }
            treeDepth ++;
        }
        return treeDepth;
    }
}
// @lc code=end

