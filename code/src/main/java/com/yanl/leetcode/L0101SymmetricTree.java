package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class L0101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSym(root.left, root.right);
    }

    /**
     * 对称二叉树
     * 判断左子树的左子树和右子树的右子树   左子树的右子树和右子树的左子树
     * 递归出口为-----  空或者 左子树和右子树不相等------------
     * @param left
     * @param right
     * @return
     */
    public boolean isSym(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }

    /**
     * 迭代实现，使用队列一次出去两个元素进行比较
     * @param root
     * @return
     */
    public boolean isSymmetricTree(TreeNode root){
        if(root == null){
            return true;
        }
        /*
        频繁的插入、删除操作：LinkedList
        频繁的随机访问操作：ArrayDeque
        该题频繁插入删除
        */
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }
            //左节点的左节点和右子树的右节点
            queue.offer(node1.left);
            queue.offer(node2.right);
            //左子树的右节点和右子树的左节点
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
