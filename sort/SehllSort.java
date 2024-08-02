package sort;

import java.util.Arrays;

public class SehllSort {
    // 基于插入排序的改进方式
    // 遍历数组的时候从length/2开始逐渐减小数组位置的增量
    // 排序好一次之后减小增量后再按新的增量排序
    // 理论上说只要增量最后是1都可以拿来当增量的变化模式使用
    // 但是有几种比较高效的
    // 1. 希尔序列 数组长度的二分之一的n次方，到取整1为止
    // 2. Hibbard序列 {2^k - 1, ... , 3, 1} (k = 0, ..., )
    // 3. Sedgewick序列 {..., 109, 41, 19, 5, 1} (9*4^i-9*2^i+1或者4^i-3*2^i+1)
    // 目前无法证明哪个是最好的
    public int[] sortArray(int[] nums) {
        if (nums == null ||  nums.length == 0) {
            return new int[]{};
        }
        int length = nums.length;
        int gap = length/2;
        while (gap > 0) {
            System.out.println("==============================================================");
            System.out.println("current gap is " + gap);
            for (int i = gap; i<length; i++) {
                // 前方排序过的起始位置
                int prePos = i - gap;
                // 当前元素的值
                int currVal = nums[i];
                // 把当前元素与前方排序过的部分的每一个元素相比较
                // 当前元素比循环中的元素小的时候就依次把大的元素向后移
                // 如果找到了合适的位置就结束循环
                while (prePos >= 0 && currVal < nums[prePos]) {
                    nums[i] = nums[prePos];
                    // 每次向前的量是gap
                    prePos -= gap;
                }
                // 正确的位置是第一个比当前元素小的值的后一个位置（当然要符合gap决定的间距）
                nums[prePos + gap] = currVal;
            }
            System.out.println("current nums is " + Arrays.toString(nums));
            gap /=2;
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 9, 6, 4, 2, 8, 7};
        System.out.println(Arrays.toString(nums));
        int[] sortedArray = new SehllSort().sortArray(nums);
        System.out.println("==============================================================");
        System.out.println(Arrays.toString(sortedArray));
    }
}
