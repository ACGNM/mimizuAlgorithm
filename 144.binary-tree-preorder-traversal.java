/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 循环方式
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.empty()) {
            while(root != null) {
                res.add(root.val);
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            root = root.right; 
        }
        return res;

        // 递归方式
        // if (root == null) {
        //     return new ArrayList<>();
        // }
        // res.add(root.val);
        // res.addAll(preorderTraversal(root.left));
        // res.addAll(preorderTraversal(root.right));
        // return res;
    }
}
// @lc code=end

