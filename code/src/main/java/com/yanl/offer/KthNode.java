package com.yanl.offer;

import java.util.Stack;

/**
 * @author YanL
 * @date 0:49 2020/8/13
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4
 *
 * 注意二叉搜索树  <<左子节点<根节点<右子节点
 * 因此中序遍历即为有序序列
 */
public class KthNode {
    int count;
    TreeNode res = null;
    TreeNode kthNode(TreeNode pRoot, int k){
        if(pRoot == null){
            return null;
        }
        dfs(pRoot, k);
        return res;
    }

    /**
     * 递归版本
     * @param pRoot
     * @param k
     */
    void dfs(TreeNode pRoot, int k){
        if(count < k && pRoot.left != null){
            dfs(pRoot.left, k);
        }
        if(++count == k){
            res = pRoot;
        }
        if(count < k && pRoot.right != null){
            dfs(pRoot.right, k);
        }
    }

    /**
     * 递归方法
     * 使用栈记录元素
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode kthNodeV2(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while (!stack.isEmpty() || cur != null){

            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if(--k == 0){
                    return cur;
                }
            }
        }
        return null;
    }
}
