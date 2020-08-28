package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 1:22 2020/8/29
 * 合并两个有序链表
 */
public class L0021MergeTwoLists {
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
