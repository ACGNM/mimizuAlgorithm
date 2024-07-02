/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i=0, j=0;
        int len = nums.length;
        while(j<len) {
            // 双指针，j向i后找非零元素直到找到并赋给i
            // 判断基准是慢指针i
            // 因为多一次赋值所以效率不高
            // if (nums[i] == 0) {
            //     while(j<len) {
            //         if (nums[j] != 0) {
            //             nums[i] = nums[j];
            //             nums[j] = 0;
            //             break;
            //         } else {
            //             j++;
            //         }
            //     }
            // }
            // i++;
            // j++;

            // 双指针，j扫描非0元素赋给i，i最后是非零元素个数
            // 判断基准是快指针j
            if (nums[j] == 0) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        while (i<len) {
            nums[i] = 0;
            i++;
        }
    }
}
// @lc code=end

