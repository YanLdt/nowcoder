package com.yanl.offer;

/**
 * @author YanL
 * @date 14:52 2020/8/11
 * 查找链表的环入口
 * 假设链表环长为b,非环长为a
 * 两个指针
 * fast-2步 f为走的距离
 * slow-1步 s为走的距离
 * 第一次相遇 f = s + n * b(n个环的长度)=2*s
 * =========>s = n * b
 * 如果从头节点开始走到入口需要走的长度为 a+n*b;
 * 此时========>   s = n * b,所以只需要再走 a 就可以到达入口-->
 * 如果要到达环入口，则需要让s = a + n * b;
 * a 为非环链表长度，所以将一个指针指向头节点，走过a长度就到达入口，
 * 此时慢指针同时以同样的速度走，两者将会在环入口节点相遇。
 *
 */
public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        //首先判断链表是否有环
        if(pHead == null){
            return null;
        }
        ListNode slowNode = pHead;
        ListNode fastNode = pHead;
        do {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            //此时相遇
        } while (fastNode != slowNode);
        fastNode = pHead;
        while (slowNode != fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }
}
