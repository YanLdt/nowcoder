package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 1:02 2020/8/29
 * 反转链表
 */
public class L0206ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode recursive(ListNode head){
        //newHead是head.next反转过来的头节点 所以尾节点是 head.next
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
