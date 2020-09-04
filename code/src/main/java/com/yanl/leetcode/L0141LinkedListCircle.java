package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 10:56 2020/9/4
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
public class L0141LinkedListCircle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            //如果快节点到达末尾，为空的时候说明链表没环
            if(fast == null || fast.next == null){
                return false;
            }
            //慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
