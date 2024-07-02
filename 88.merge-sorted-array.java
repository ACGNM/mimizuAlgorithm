/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
// 双指针
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int a = 0, b = 0;
        if(nums2.length == 0) { return; }
        for(int i = 0; i<m+n; i++) {
            if(b>=n || (a<m && nums1[a] < nums2[b])) {
                result[i] = nums1[a];
                a++;
            } else {
                result[i] = nums2[b];
                b++;
            }
        }
        for(int j = 0; j<m+n; j++) {
            nums1[j] = result[j];
        }
    }
}
// @lc code=end

