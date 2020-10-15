package com.yanl.leetcode;

import com.yanl.leetcodeutil.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YanL
 * @date 21:22 2020/10/15
 * 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，、
 * 则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 层次遍历  遍历到每层最后一个元素  不再链接next指针
 */
public class L0116PopulateNextRightNode {
    public Node connect(Node root){
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                Node cur = queue.poll();
                if(i < size - 1){
                    cur.next = queue.peek();
                }
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

