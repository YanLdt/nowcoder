package com.yanl.leetcode;

import com.yanl.leetcodeutil.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YanL
 * @date 14:49 2020/9/28
 * 填充每个节点的下一个右侧节点指针 II
 *填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 把节点当作链表节点串起来
 *
 */
public class L0117PopulateNextRightNode2 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node last = null;
            for(int i = 0; i < size; i ++){
                Node cur = queue.poll();
                if(last != null){
                    last.next = cur;
                }
                last = cur;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
