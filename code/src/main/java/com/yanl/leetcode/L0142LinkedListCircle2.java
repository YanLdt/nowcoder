package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 11:13 2020/9/4
 * 环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class L0142LinkedListCircle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do{
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while (fast != slow);
        fast = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
