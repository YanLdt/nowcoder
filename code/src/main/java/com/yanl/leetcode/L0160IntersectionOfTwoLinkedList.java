package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 0:49 2020/9/14
 * 链表相交的起始节点
 *
 */
public class L0160IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2){
            //如果h1到达末尾则将h1置为h2
            if(h1 == null){
                h1 = headB;
            }else {
                h1 = h1.next;
            }
            //如果h2到达末尾则将h2置为h1
            if(h2 == null){
                h2 = headA;
            }else {
                h2 = h2.next;
            }
        }
        return h1;
    }
}
