package com.yanl.leetcode;

import com.yanl.leetcodeutil.ListNode;

/**
 * @author YanL
 * @date 23:44 2020/8/19
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 思路 用carry来代表进位，初始化一个空节点，并指向结果
 * 然后循环迭代l1,l2,直到两个链表都为空，
 *  循环过程中 下一个节点的值为 sum % 10
 *            进位为 carry = sum / 10
 *  循环结束判断进位是否大于0，大于0在后面再添加一个节点
 *  最后返回空节点的next
 */
public class L0002AddTwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
