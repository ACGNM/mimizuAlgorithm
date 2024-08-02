package sort;

import java.util.Arrays;

public class BubbleSort {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // 从头开始两两比较，把大的向后交换
        // 每次循环结束后最后的几位都已经排好序所以可以循环到排好序的位置之前来优化次数
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++){
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;

                    System.out.println(Arrays.toString(nums));
                }
            }
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] sortedArray = new BubbleSort().sortArray(new int[]{3, 1, 5, 4, 2, 6, 9, 8});
        System.out.println(Arrays.toString(sortedArray));
    }
}
