/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> anotherMap = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i<nums.length; i++) {
            Integer temp = target - nums[i];
            Integer another = anotherMap.get(temp);
            if(Objects.isNull(another)) {
                anotherMap.put(nums[i], i);
            } else {
                result[0] = another;
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

