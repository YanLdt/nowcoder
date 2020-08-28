package com.yanl.leetcodeutil;

/**
 * @author YanL
 * @date 0:20 2020/8/20
 * 给你一个链表反转链表
 */
public class ReverseList {
    /**
     * 迭代法反转链表
     * @param node
     * @return
     */
    public ListNode reverseList(ListNode node){
        if(node == null){
            return null;
        }
        ListNode pre = null;
        ListNode next;
        while (node != null){
            //先存储node的next 防止链表丢失
            next = node.next;
            //将node的下一个节点指向空节点，即变为最后一个节点
            node.next = pre;
            //然后将pre=node
            pre = node;
            //node变为next
            node = next;
        }
        return pre;
    }

    /**
     * 递归方法反转链表
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //先把head取出来然后head.next就是剩余部分的头指针
        ListNode newHead = reverseList(head.next);
        //head.next为新链表的尾指针，所以head.next.next = head
        head.next.next = head;
        //然后将head置为末尾指针
        head.next = null;
        return newHead;
    }
}
