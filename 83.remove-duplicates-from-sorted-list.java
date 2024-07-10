/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 一样的话就让next指向下一个的下一个，只有取到不同节点时才移动指针
        if (head == null) return head;
        ListNode result = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;

        // 递归，因为是有序列表，所以把第一个跟剩下经过处理的列表的第一个元素对比
        // 如果相同就把第一个元素的next指向剩下列表结果的第二个元素
        // if (head == null || head.next == null) return head;
        // ListNode rest = deleteDuplicates(head.next);
        // if (head.val == rest.val) {
        //     head.next = rest.next;
        // }
        // return head;
    }
}
// @lc code=end

