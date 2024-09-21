/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n-1;
        while (start < end) {
            int pos = (start + end) / 2;
            if (nums[pos] == target) {
                return pos;
            } else if (nums[pos] > target) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
        }
        if (nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
// @lc code=end

