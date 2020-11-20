package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 10:18 2020/11/20
 */
public class L0143InsertionSortList {
    public ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = head, cur = head.next;
        while (cur != null){
            //如果 当前值大于已排序链表的最后一个值  直接插入
            if(last.val <= cur.val){
                last = last.next;
            }else {
                //否则 从头开始遍历  找到插入当前值的位置
                ListNode pre = dummy;
                while (pre.next.val <= cur.val){
                    pre = pre.next;
                }
                //将当前节点插入  首先将最后一个节点的下一个节点设为没有排序的下一个节点
                //然后将 当前节点的下一个节点置为 已排序链表的第一个比当前节点值大的节点
                //最后将 已排序链表的最后一个比当前节点值小的节点 的 下一个节点置为当前节点
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = last.next;
        }
        return dummy.next;

    }
}
