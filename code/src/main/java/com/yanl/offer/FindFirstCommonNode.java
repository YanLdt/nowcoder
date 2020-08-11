package com.yanl.offer;

/**
 * @author YanL
 * @date 9:36 2020/8/10
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 公共节点肯定在尾部
 *
 */
public class FindFirstCommonNode {
    /**
     * 通过比较两个链表的长度
     * 让长链表先走两者之差的长度，之后再一起遍历链表，直到找到相同节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode findFirst(ListNode pHead1, ListNode pHead2){
        int len1 = getLen(pHead1);
        int len2 = getLen(pHead2);
        ListNode pNodeLong = pHead1;
        ListNode pNodeShort = pHead2;
        int lenDiff = len1 - len2;
        if(len1 < len2){
            pNodeLong = pHead2;
            pNodeShort = pHead1;
            lenDiff = len2 - len1;
        }
        for (int i = 0; i < lenDiff; i++) {
            pNodeLong = pNodeLong.next;
        }
        while (pNodeLong!=null && pNodeShort != null && pNodeLong != pNodeShort){
            pNodeLong = pNodeLong.next;
            pNodeShort = pNodeShort.next;
        }
        return pNodeLong;
    }

    /**
     * 获取链表长度
     * @param pHead
     * @return
     */
    public static int getLen(ListNode pHead){
        int len = 0;
        ListNode node = pHead;
        while (node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}


