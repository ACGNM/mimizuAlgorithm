/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    // 一个数跟自己异或一定为0。任何数和0异或都是自己
    // 异或适用交换律
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
// @lc code=end

