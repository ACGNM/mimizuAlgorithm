/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 循环方式
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.empty()) {
            while(root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            res.add(root.val);
            root = root.right; 
        }
        return res;

        // 递归方式
        // if (root == null) {
        //     return new ArrayList<>();
        // }
        // res.addAll(inorderTraversal(root.left));
        // res.add(root.val);
        // res.addAll(inorderTraversal(root.right));
        // return res;
    }
}
// @lc code=end

