package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class RedixSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        // 找出最大值从而确定位数
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // 计算最大位数
        int digit = 0;
        while (max != 0) {
            max /= 10;
            digit++;
        }

        // 创建桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>();
        // 每个桶存储当前位为0～9的数字
        for (int i = 0; i < 10; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 从个位开始计算每一位的值并放进对应的桶
        int mod = 10, div = 1;
        for (int i = 0; i < digit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < len; j++) {
                int pos = nums[j] % mod / div;
                bucketArr.get(pos).add(nums[j]);
            }

            // 查看桶内容
            System.out.print("=============== digit " + i + " ===================\n");
            for (int a = 0; a < 10; a++) {
                System.out.print("Bucket No." + a + " is \n");
                System.out.println(bucketArr.get(a));
            }
            // 按照当前位的数字排序好的元素放回原来数组中
            // 清空桶为下一次排序做准备
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketArr.get(j).size(); k++) {
                    nums[index++] = bucketArr.get(j).get(k);
                }
                bucketArr.get(j).clear();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{86, 39, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};
        System.out.println(Arrays.toString(nums));
        int[] sortedArray = new RedixSort().sortArray(nums);
        System.out.println(Arrays.toString(sortedArray));
    }
}
