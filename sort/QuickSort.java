package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    // 使用递归的方式
    // 先选取一个pivot作为基准值，把小于基准值的放左边，大于基准值的放右边
    // 选取基准值后放到最后一位，然后一个指针记录当前遍历位置和一个分区指示器指针（也记录了当前小于基准值个数）
    // 这样分区指示器指向的元素及其前面的元素正好是当前遍历所到位置的小于基准值的元素们
    // 具体步骤为：
    // 1. 判断当前元素跟基准值的大小关系
    // 2. 如果大于什么都不做比较下一个
    // 3. 如果小于则分区指示器向后移动一个（小于的个数+1），同时如果当前指针位置大于分区指示器位置则交换
    // 3.1 相当于把遍历到的小数放到前面去
    public int[] sort(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    public int[] sortArray(int[] nums, int start, int end) {
        int index = partition(nums, start, end);
        if (index > start) {
            sortArray(nums, start, index - 1);
        }
        if (index < end) {
            sortArray(nums, index + 1, end);
        }
        return nums;
    }

    public int partition(int[] nums, int start, int end) {
        System.out.println("Array to be sorted is " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
        if (start == end) {
            System.out.println("==============================================================");
            return start;
        }
        Random random = new Random();
        int pivot_pos = random.nextInt((end - start) + 1) + start;
        int pivot = nums[pivot_pos];
        System.out.println("Current pivot is " + pivot);
        int index = start - 1;
        swap(nums, pivot_pos, end);
        // 这里的<=相当于最后把pivot换到它所在的位置了
        for (int i = start; i <= end; i++) {
            if (nums[i] <= pivot) {
                index ++;
                if (i > index) {
                    swap(nums, i, index);
                }
            }
        }
        System.out.println("After sorting is " + Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
        System.out.println("==============================================================");
        return index;
    }

    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 9, 6, 4, 2, 8, 7};
        System.out.println(Arrays.toString(nums));
        int[] sortedArray = new QuickSort().sort(nums);
        System.out.println(Arrays.toString(sortedArray));
    }

    // 优化方法
    // 1. 可以设置两个基准值分成三组来排序
    // 2. 可以设置一个阈值，当子数组大小小于它时使用其他排序（如插入排序）进行排序最后组合
    // 2.1 Java的JDK用的就是这种方式
}
