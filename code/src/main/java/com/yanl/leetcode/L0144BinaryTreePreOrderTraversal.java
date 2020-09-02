package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author YanL
 * @date 13:33 2020/9/2
 * 二叉树前序遍历
 */
public class L0144BinaryTreePreOrderTraversal {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    /**
     * 递归前序遍历
     * @param root
     * @param res
     */
    public void recursive(TreeNode root, List<Integer> res){
        if(root != null){
            res.add(root.val);
            recursive(root.left, res);
            recursive(root.right, res);
        }
    }

    /**
     * 先序遍历迭代
     * 先压入根节点，然后将根节点出栈，压入右子节点和左子节点
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if(tmp.left != null){
                stack.push(tmp.left);
            }
        }
        return res;
    }
}
