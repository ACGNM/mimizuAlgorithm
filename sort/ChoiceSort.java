package sort;

import java.util.Arrays;

public class ChoiceSort {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // 每次找到未排序部分中的最大值，移动到未排序部分的最后一位
        for (int i = 0; i < n - 1; i++) {
            int maxPos = 0;
            for (int j = 0; j < n-i; j++) {
                if (nums[maxPos] < nums[j]) {
                    maxPos = j;
                }
            }
            int temp = nums[n-i-1];
            nums[n-i-1] = nums[maxPos];
            nums[maxPos] = temp;

            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] sortedArray = new ChoiceSort().sortArray(new int[]{3, 1, 5, 4, 2, 6, 9, 8});
        System.out.println(Arrays.toString(sortedArray));
    }
}
