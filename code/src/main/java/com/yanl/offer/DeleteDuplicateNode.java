package com.yanl.offer;

/**
 * @author YanL
 * @date 0:10 2020/8/12
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicateNode {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode vNode = new ListNode(-1);
        vNode.next = pHead;
        ListNode pre = pHead, cur = pHead;
        ListNode tail = vNode;
        for(; pre != null; pre = cur){
            //只要当前节点不为空，且等于前面的节点就一直循环
            while (cur != null && cur.val == pre.val){
                cur = cur.next;
            }
            //如果前后两个节点不相等 直接插入
            if(pre.next == cur){
                tail.next = pre;
                tail = pre;
                tail.next = null;
            }
        }
        return vNode.next;
    }
}
