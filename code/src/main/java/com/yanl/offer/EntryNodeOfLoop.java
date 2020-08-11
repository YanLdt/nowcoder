package com.yanl.offer;

/**
 * @author YanL
 * @date 14:52 2020/8/11
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
    }
}
