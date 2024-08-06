package sort;

import java.util.Arrays;

// 堆是满足一定条件的完全二叉树
// 条件就是每个子树的根节点的值都大于（或者小于）子节点
// 这时就形成了最大堆（或者最小堆）
// 可以实现部分排序，每次只取出最大（最小）值
// 通过不断把根节点与最后一个叶节点交换的形式来从堆中除去，然后再重新调整树使其满足最大（最小）堆来排序
public class HeapSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len < 0) return nums;
        buildMaxHeap(nums);
        System.out.println("After building Max Heap is \n" + Arrays.toString(nums));
        System.out.println("==============================================================");
        int count = 0;
        while (len > 0) {
            swap(nums, 0, len-1);
            len --;
            adjustMaxHeap(nums, 0, len);
            count ++;
            System.out.println("After " + count + "th adjuest is \n" + Arrays.toString(nums));
            System.out.println("==============================================================");
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void buildMaxHeap(int[] nums) {
        int n = nums.length;
        // 根据叶节点是根节点的二倍加一或者加二可以得到逆向计算
        // 整数除法会舍弃小数点但是用的是长度而非编号最大值所以可以找到第一个非叶节点的编号
        // 完全二叉树中叶节点的开始位置是len/2向上取余
        int firstSubRoot = n/2 - 1;
        // 从第一个非叶节点开始调整成为最大堆
        for (int i = firstSubRoot; i >= 0; i--) {
            adjustMaxHeap(nums, i, n);
        }
    }

    public void adjustMaxHeap(int[] nums, int rootPos, int n) {
        int leftPos = 2 * rootPos + 1;
        int rightPos = leftPos + 1;
        int maxPos = rootPos;
        if (leftPos < n && nums[leftPos] > nums[maxPos]) {
            maxPos = leftPos;
        }
        if (rightPos < n && nums[rightPos] > nums[maxPos]) {
            maxPos = rightPos;
        }
        if (maxPos != rootPos) {
            swap(nums, rootPos, maxPos);
            // 如果发生了交换，则交换后的结果可能导致其子树又不满足最大堆，所以递归调整
            adjustMaxHeap(nums, maxPos, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(5/2);
        int[] sortedArray = new HeapSort().sortArray(new int[]{3, 1, 5, 9, 6, 4, 2, 8, 7});
        System.out.println(Arrays.toString(sortedArray));
    }
}
