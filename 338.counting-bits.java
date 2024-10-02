/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    // 当前数字为n的时候，其中1的个数是 n&(n-1)之后数字的1的个数加1
    // 相当于寻找排除了最低位的1那个数
    // 1000 0100 -> 和1000 0011进行与运算 -> 1000 0000（排除掉了最低位置的1）
    // 然后使用动态规划存储之前的结果  因为f(n) = f(n&(n-1))
    // public int[] countBits(int n) {
    //     int[] bits = new int[n + 1];
    //     for (int i = 1; i <= n; i++) {
    //         bits[i] = bits[i&(i-1)] + 1;
    //     }
    //     return bits;
    // }

    // 使用奇偶判断
    // 奇数一定比前面的偶数多一个1
    // 偶数等于右移之后的结果（除以2）
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            bits[i] = (i&1) ==0 ? bits[i>>1] : bits[i-1] + 1;
        }
        return bits;
    }
}
// @lc code=end

