package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 0:23 2020/8/31
 * 删除链表的倒数第N个节点
 */
public class L0019RemoveNthNode {
    public ListNode removeNthNodeFromEnd(ListNode head, int n){
        if(head == null){
            return null;
        }
        //设置虚拟节点，一般都将虚拟节点的下一个节点设为head节点
        //辅助节点一般都设为虚拟节点
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode slow = res;
        ListNode fast = res;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }
}
