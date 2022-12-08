/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;//链表的元素
 *     ListNode next;//链表的下一个元素
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);//初始化一个存放结果的链表,-1表示不存放数据的头结点
        ListNode p = dummy;//初始化另一个与dummy指向同一块内存地址的链表。p参与循环进行数据获取（p获取完数据后，p.next指向了null），dummy不参与循环，用于数据输出

        int carry = 0;//存放进位

        while (l1 != null || l2 != null || carry > 0) {

            int val = carry;//val是p的元素，val = carry + l1.val + l2.val

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            // 处理进位情况
            carry = val / 10;
            val = val % 10;

            // 存入p
            p.next = new ListNode(val);
            p = p.next;
        }
        
        return dummy.next;
    }
}
// @lc code=end

