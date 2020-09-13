package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

import java.util.List;

/**
 * @author YanL
 * @date 17:39 2020/9/13
 * 排序链表--迭代方法
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 归并排序
 * 首先找到中间节点
 */
public class L0148SortLists {
    /**
     * 迭代版本  不符合题意 迭代需要O(log n)的空间复杂度
     * @param head
     * @return
     */
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
        //递归排序左右两段链表
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

    public ListNode sortListV2(ListNode head){
        //首先求链表的长度
        int n = 0;
        for(ListNode i = head; i != null; i = i.next){
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //外层循环  1个一组 -> 2个一组 -> 4个一组----->直到n个一组进行归并操作
        //i指的是每个分段的长度
        for(int i = 1; i < n; i *= 2){
            ListNode start = dummy;
            // j + i >= n 表示只有一段就不归并了，因为已经是排好序的
            //j指向的是每段进行二路归并的起点
            for(int j = 0; j + i < n; j = i * 2 + j){
                ListNode first = start.next, second = first;
                for(int k = 0; k < i; k ++){
                    second = second.next;
                }
                //f s分别指向归并链表的第一段和第二段的指针
                int f = 0, s = 0;
                //这边进行归并操作
                while (f < i && s < i && second != null){
                    if(first.val < second.val){
                        start.next = first;
                        start = start.next;
                        first = first.next;
                        f++;
                    }else {
                        start.next = second;
                        start = start.next;
                        second = second.next;
                        s++;
                    }
                }
                //如果没有归并完
                while (f < i){
                    start.next = first;
                    start = start.next;
                    first = first.next;
                    f++;
                }
                while (s < i && second != null){
                    start.next = second;
                    start = start.next;
                    second = second.next;
                    s++;
                }
                //循环出来的时候second已经是下一段的起点了
                //将指针指向下一组的起点然后开始归并后面的两个分组
                start.next = second;
            }
        }
        return dummy.next;
    }
}
