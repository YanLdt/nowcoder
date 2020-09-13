package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

import java.util.List;

/**
 * @author YanL
 * @date 17:39 2020/9/13
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 归并排序
 * 首先找到中间节点
 */
public class L0148SortLists {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //后半段的起始节点
        ListNode rightList = slow.next;
        //分段
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightList);
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (left != null && right != null){
            if(left.val < right.val){
                dummy.next = left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left == null ? right : left;
        return res.next;
    }
}
