/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 双指针先都循环到各自链表尾部，然后交换到另外一个队列的头继续遍历直到相等（这时可能是交叉点也可能都是null）
        // 因为队列元素的长短差在交换的时候被弥补了，相当于在相遇前同时出发 O(m+n)
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;

        // 先获取长度之后再把起点对齐 O(m+n)
        // int lenA = 0;
        // int lenB = 0;
        // ListNode pa = headA;
        // ListNode pb = headB;
        // while (pa.next != null) {
        //     lenA++;
        //     pa = pa.next;
        // }
        // while (pb.next != null) {
        //     lenB++;
        //     pb = pb.next;
        // }
        // if (pa != pb) {
        //     return null;
        // }
        // int diff = 0;
        // if (lenA > lenB) {
        //     diff = lenA - lenB;
        //     pa = headA;
        //     pb = headB;
        // } else {
        //     diff = lenB - lenA;
        //     pa = headB;
        //     pb = headA;
        // }
        // for (int i = 0; i<diff; i++) {
        //     pa = pa.next;
        // }
        // while (pa != pb) {
        //     pa = pa.next;
        //     pb = pb.next;
        // }
        // return pa;
    }
}
// @lc code=end

