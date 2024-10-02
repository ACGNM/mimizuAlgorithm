/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    // 异或可以找出两个数不同的位数
    // 然后就是数异或结果中1的位数，同338题
    // 通过与n-1来一步一步消除当前最低位的1，直到0为止，消除的1的个数（循环次数）就是1的位数
    public int hammingDistance(int x, int y) {
        int distance = 0;
        for (int xor = x ^ y; xor !=0; xor = xor&(xor-1)) {
            distance++;
        }
        return distance;
    }
}
// @lc code=end

