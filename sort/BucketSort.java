package sort;

import java.util.ArrayList;
import java.util.Arrays;

// 设定排序数字范围的几个桶
// 每个桶代表一个数字的范围，范围内的数字单独排序然后取出组成结果
public class BucketSort {
    public int[] sortArray(int[] nums, int bucketGap) {
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
        // 创建桶
        // 桶的个数由设定的桶间距和最大最小值决定
        int bucketCount = (max - min) / bucketGap + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将数组中对应的数字放入桶中
        for (int i = 0; i < len; i++) {
            bucketArr.get((nums[i] - min)/bucketCount).add(nums[i]);
        }

        int total = 0;
        for (int i = 0; i < bucketCount; i++) {
            // 每个桶中的元素进行排序。可以是任意排序方法
            bucketArr.get(i).sort(null);
            // 将桶中的数字按顺序取出到原数组
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                nums[total++] =  bucketArr.get(i).get(j);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{35, 23, 48, 9, 16, 24, 5, 11, 32, 17};
        System.out.println(Arrays.toString(nums));
        int[] sortedArray = new BucketSort().sortArray(nums, 5);
        System.out.println(Arrays.toString(sortedArray));
    }
}
