package sort;

import java.util.Arrays;

// 一种桶排序
// 把每个元素的个数放入桶中然后依次取出
// 适用于大小相近，有重复元素的排序
public class CounterSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        // 找出最大最小值从而确定计数数组的范围
        int max = nums[0], min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        // 创建计数数组
        int counterLen = max - min + 1;
        int[] counterArray = new int[counterLen];
        // 统计各个元素的个数
        for (int i = 0; i < len; i++) {
            counterArray[nums[i]-min]++;
        }
        // 遍历计数数组，各个元素的计数减到零为止将对应元素放回原数组中
        for (int i = 0, j=0; i < counterLen; i++) {
            while (counterArray[i] > 0) {
                nums[j++] = i + min;
                counterArray[i]--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,3,0,2,3,0,3,9,6,5,7,6};
        System.out.println(Arrays.toString(nums));
        int[] sortedArray = new CounterSort().sortArray(nums);
        System.out.println(Arrays.toString(sortedArray));
    }
}
