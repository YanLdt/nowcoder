package com.yanl.tencent;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:02 2020/9/6
 * 链表的公共部分
 */
public class CommonPartOfNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        Node node1 = new Node(-1);
        Node cur1 = node1;
        for(int i = 0; i < len1; i ++){
            cur1.next = new Node(sc.nextInt());
            cur1 = cur1.next;
        }
        int len2 = sc.nextInt();
        Node node2 = new Node(-1);
        Node cur2 = node2;
        for(int i = 0; i < len2; i ++){
            cur2.next = new Node(sc.nextInt());
            cur2 = cur2.next;
        }
        find(node1.next, node2.next);
    }

    public static void find(Node node1, Node node2){
        Node cur1 = node1;
        Node cur2 = node2;
        while (node1.next != null && node2.next != null){
            if(node1.val < node2.val){
                node2 = node2.next;
            }else if(node1.val > node2.val){
                node1 = node1.next;
            }else {
                System.out.print(node1.val + " ");
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }
}


class Node{
    int val;
    Node next;

    public Node(int x){
        this.val = x;
    }
}