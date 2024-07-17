/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 循环方式
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !nodeStack.empty()) {
            while(root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            // 当前节点是左或右叶节点或者上一次右节点出栈（当前为中间节点）
            if (root.right == null || root.right == preNode) {
                res.add(root.val);
                preNode = root;
                // 为了跳过一开始的寻找左叶到底的操作
                // 因为此时是叶节点出栈或者右节点出栈后的中间出栈，下一步需要的是让当前子树的父节点出栈
                // 因为一开始的找到最左决定了左子树的节点先出栈之后就是中间节点的固有模式
                root = null;
            // 如果是中间节点并且右叶节点还没出栈，先再把中间节点压回去
            } else {
                nodeStack.push(root);
                root = root.right;
            }
        }
        return res;

        // 递归方式
        // if (root == null) {
        //     return new ArrayList<>();
        // }
        // res.addAll(postorderTraversal(root.left));
        // res.addAll(postorderTraversal(root.right));
        // res.add(root.val);
        // return res;
    }
}
// @lc code=end

