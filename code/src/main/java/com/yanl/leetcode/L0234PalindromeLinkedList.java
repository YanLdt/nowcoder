package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 10:50 2020/9/19
 * 回文链表
 */
public class L0234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        ListNode fast = head;
        //快慢指针找中点并且反转前面的链表
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //如果节点有奇数个则需要跳过中间的节点
        if(fast != null){
            cur = cur.next;
        }
        while (pre != null && cur != null){
            if(pre.val == cur.val){
                pre = pre.next;
                cur = cur.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
