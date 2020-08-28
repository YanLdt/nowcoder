package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 1:32 2020/8/29
 * 合并k个升序链表
 */
public class L0023MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1 == null){
            tmp.next = l2;
        }
        if(l2 == null){
            tmp.next = l1;
        }
        return res.next;
    }
}
