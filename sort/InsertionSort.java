package sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] sortArray(int[] nums) {
        // 从第二个元素开始，将当前元素插入到向前方已经排序过的部分中合适的位置
        // 遵循大的元素放后面的原则
        int n = nums.length;
        if (n == 0 || n ==1) {
            return nums;
        }
        // 当前已经排序过的位置
        int currPos = 0;
        for (int i = 1; i < n; i++) {
            int j = currPos;
            int currVal = nums[i];
            // 把当前元素与前方排序过的部分的每一个元素相比较
            while (j >= 0) {
                // 当前元素比循环中的元素小的时候就依次把大的元素向后移
                if (currVal < nums[j]) {
                    nums[j+1] = nums[j];
                    j--;
                } else {
                    // 如果找到了合适的位置就结束循环
                    break;
                }
            }
            // 结束循环时j的位置的后一个就是正确的插入位置
            // 因为nums[j]是第一个比nums[i]小的蒜素，是当前元素的前一个位置
            nums[j+1] = currVal;
            currPos++;

            System.out.println("current sorted pos is " + currPos);
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] sortedArray = new InsertionSort().sortArray(new int[]{3, 1, 5, 4, 2, 6, 9, 8});
        System.out.println(Arrays.toString(sortedArray));
    }
}
