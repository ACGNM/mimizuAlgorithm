/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start

import java.util.Arrays;

// 归并+插入排序
// 改进的话可以把归并的任务多线程执行
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        if (n < 17) {
            return insersionSort(nums);
        }
        int pos = n/2;
        return merge(
            sortArray(Arrays.copyOfRange(nums, 0, pos)), 
            sortArray(Arrays.copyOfRange(nums, pos, n)));
    }

    public int[] merge(int[] left, int[] right) {
        int n = left.length, m = right.length;
        int[] result = new int[m+n];
        int i = 0, j = 0;
        for (int index = 0; index < n+m; index++) {
            if (i >= n) {
                result[index] = right[j++]; 
            } else if (j >= m) {
                result[index] = left[i++];
            } else if (left[i] < right[j]) {
                result[index] = left[i++];
            } else {
                result[index] = right[j++]; 
            }
        }
        return result;
    }

    public int[] insersionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int currVal = nums[i];
            int j = i-1;
            while (j >=0 && currVal < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = currVal;
        }
        return nums;
    }
}
// @lc code=end

