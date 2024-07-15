/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        // 用栈来暂存字符，遇到右括号进行重复字符的生成
        Stack<String> inputStack = new Stack<String>();
        int p = 0;
        
        while (p < s.length()) {
            char curr = s.charAt(p);
            if (curr != ']') {
                inputStack.push(String.valueOf(curr));
                p++;
            } else {
                inputStack.push(decodeSubStr(inputStack));
                p++;
            }
        }
        Stack<String> outputStack = new Stack<String>();
        String result = "";
        while (!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
        while (!outputStack.empty()) {
            result += outputStack.pop();
        }
        return result;
    }

    public String decodeSubStr(Stack<String> stack) {
        Stack<String> outputStack = new Stack<String>();
        while (!stack.empty() && stack.peek().charAt(0) != '[') {
            outputStack.push(stack.pop());
        }
        String repeated = "";
        while (!outputStack.empty()) {
            repeated += outputStack.pop();
        }
        stack.pop();
        int digit = 0, repeat_num = 0;
        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
            repeat_num += Math.pow(10, digit)*(Integer.parseInt(stack.pop()));
            digit++;
        }
        String result = "";
        for (int i = 0; i < repeat_num; i++) {
            result += repeated;
        }
        return result;
    }

    // 改进方法是可以减少最后拼凑结果的过程
    // 每次遇到左括号就把之前的非数字字符串存起来，右括号拼凑的时候直接跟前面的字符串组合
    // 用两个栈，一个次数栈，一个字符栈
}
// @lc code=end

