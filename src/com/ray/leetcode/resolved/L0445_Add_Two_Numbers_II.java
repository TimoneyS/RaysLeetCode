package com.ray.leetcode.resolved;

import com.ray.leetcode.util.ListNode;
import com.ray.util.Out;

/**
 * Add Two Numbers II
 * -----------------------------------------------------------------------------
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *      Example 1
 *      Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      Output: 7 -> 8 -> 0 -> 7
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @since   2020-04-14 23:08:21
 */
public class L0445_Add_Two_Numbers_II {
    /**
     * 先计算两个链表的长度差，然后递归的时候通过这个差，使两个链表尾部对齐
     * 保证计算时，拿到的两个结点是对齐的
     *
     * 比如：
     *      1 -> 2 -> 3 -> 4 -> 5
     *      1 -> 2 -> 3
     *  两个链表，长度差 dif = 2
     *  第一层递归
     *      l1 = 1, l2 = 1, dif = 2
     *      通过 dif 知道，结点没有对齐，因此 l1前进，l2不前进
     *  第二层递归
     *      l1 = 2, l2 = 1, dif = 1
     *      结点没有对齐，因此 l1前进，l2不前进
     *  第三层递归
     *      l1 = 3, l2 = 1, dif = 0
     *      dif = 0, 结点已经对齐，可以计算，但是要处理进位，因此做好先计算下一个结点
     *      因此先向下递归，递归后在计算当前结点的和
     *
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int dif = 0;
            for (ListNode n = l1; n != null; n = n.next) dif++;
            for (ListNode n = l2; n != null; n = n.next) dif--;
            // 保证 l1 总是较长的那个链表
            ListNode rs = dif > 0 ? helper(l1, l2, dif) : helper(l2, l1, -dif);
            // 处理第一位也要进位的情况
            if (rs != null && rs.val > 9) {
                ListNode n = rs;
                rs = new ListNode(rs.val/10);
                n.val %= 10;
                rs.next = n;
            }
            return rs;
        }

        private ListNode helper(ListNode l1, ListNode l2, int dif) {
            if (l1 == null) return null;
            // 如果 dif 大于 0 说明没有对齐，则只要 l1 前进；否则两个都前进，求取下一对结点
            ListNode nextNode = dif <= 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, dif - 1);
            // 下一个结点如果需要进位，则加上进位；同时如果 dif 大于 0， 没对齐的话，l2 的值不能用于求和。
            int val = (dif <= 0 ? l2.val : 0) + l1.val + val(nextNode) / 10;
            if (nextNode != null) nextNode.val %= 10;
            ListNode currentNode = new ListNode(val);
            // 将下一个结点，追加到当前结点的尾部
            currentNode.next = nextNode;
            return currentNode;
        }

        private int val(ListNode node) {return node == null ? 0 : node.val;}
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
