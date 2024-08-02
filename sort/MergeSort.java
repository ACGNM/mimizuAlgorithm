package sort;

import java.util.Arrays;

public class MergeSort {
    // 将数组不断二分到一个元素为止，然后再把分别排序的结果按照大小关系合并
    // 合并之前的数组是有序的，所以可以用线性时间挨个比较
    // 一种分治法
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int pos = n/2;
        return merge(
            sortArray(Arrays.copyOfRange(nums, 0, pos)), 
            sortArray(Arrays.copyOfRange(nums, pos, n)));
    }

    public int[] merge(int[] left, int[] right) {
        System.out.println("==============================================================");
        System.out.println("Merge " + Arrays.toString(left) + "and " + Arrays.toString(right));
        int n = left.length, m = right.length, i = 0, j = 0;
        int[] result = new int[n+m];
        for (int k = 0; k<n+m; k++) {
            if (i>=n) {
                result[k] = right[j];
                j++;
            }
            else if (j>=m) {
                result[k] = left[i];
                i++;
            }
            else if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
        }
        System.out.println("Merge result" + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 9, 6, 4, 2, 8, 7};
        System.out.println(Arrays.toString(nums));
        int[] sortedArray = new MergeSort().sortArray(nums);
        System.out.println("==============================================================");
        System.out.println(Arrays.toString(sortedArray));
    }
}
