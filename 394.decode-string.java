/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start

import java.util.Stack;

class Solution {
    // public String decodeString(String s) {
    //     // 用栈来暂存字符，遇到右括号依次回溯进行重复字符的生成
    //     // 然后把这些字符放回栈内供更外层的重复模式使用
    //     Stack<String> inputStack = new Stack<String>();
    //     int p = 0;
        
    //     while (p < s.length()) {
    //         char curr = s.charAt(p);
    //         if (curr != ']') {
    //             inputStack.push(String.valueOf(curr));
    //             p++;
    //         } else {
    //             inputStack.push(decodeSubStr(inputStack));
    //             p++;
    //         }
    //     }
    //     Stack<String> outputStack = new Stack<String>();
    //     String result = "";
    //     while (!inputStack.empty()) {
    //         outputStack.push(inputStack.pop());
    //     }
    //     while (!outputStack.empty()) {
    //         result += outputStack.pop();
    //     }
    //     return result;
    // }

    // public String decodeSubStr(Stack<String> stack) {
    //     Stack<String> outputStack = new Stack<String>();
    //     while (!stack.empty() && stack.peek().charAt(0) != '[') {
    //         outputStack.push(stack.pop());
    //     }
    //     String repeated = "";
    //     while (!outputStack.empty()) {
    //         repeated += outputStack.pop();
    //     }
    //     stack.pop();
    //     int digit = 0, repeat_num = 0;
    //     while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
    //         repeat_num += Math.pow(10, digit)*(Integer.parseInt(stack.pop()));
    //         digit++;
    //     }
    //     String result = "";
    //     for (int i = 0; i < repeat_num; i++) {
    //         result += repeated;
    //     }
    //     return result;
    // }

    // 改进方式就是从前往后扫描的时候就把数字压入数字栈
    // 以左方括号为界把需要重复的字符记录下来
    // 在右方括号前又出现了左方括号就压入字符串栈重新统计当前需要重复字符
    // 遇到右括号时出栈栈顶重复数字，重复当前需要重复的字符串并且与字符栈栈顶字符串合并作为新的当前需要重复字符串
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (c == '[') {
                st.push(n);
                n = 0;
                st1.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int k = st.pop();
                StringBuilder temp = sb;
                sb = st1.pop();
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
// @lc code=end

