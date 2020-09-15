package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 21:36 2020/9/15
 * 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 */
public class L0082RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = head, pre = head;
        ListNode tail = res;
        for (;pre != null; pre = cur){
            while (cur != null && pre.val == cur.val){
                cur = cur.next;
            }
            if(pre.next != cur){
                tail.next = pre;
                tail = pre;
                tail.next = null;
            }
        }
        return res.next;
    }
}
