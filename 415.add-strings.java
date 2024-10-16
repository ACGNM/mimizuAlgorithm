/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sBuilder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length()-1, j = num2.length()-1; i>=0 || j>=0; i--, j--) {
            int digit1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int digit2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int tmp = digit1 + digit2 + carry;
            sBuilder.append(tmp % 10);
            carry = tmp / 10;
        }
        if (carry == 1) {
            sBuilder.append(1);
        }
        return sBuilder.reverse().toString();
    }
}
// @lc code=end

