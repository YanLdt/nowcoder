package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author YanL
 * @date 11:58 2020/9/2
 * 二叉树中序遍历
 */
public class L0094BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    /**
     * 递归中序遍历
     * @param root
     * @param res
     */
    public void recursive(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        if(root.left != null){
            recursive(root.left, res);
        }
        res.add(root.val);
        if(root.right != null){
            recursive(root.right, res);
        }
    }

    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        //TreeNode cur = root;
        while (root != null || !stack.isEmpty()){
            //首先把左子节点全部入栈
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            //弹出最左边那个节点，此时该节点的右子节点肯定为空，继续循环，直接弹出下一个节点，
            //即上一轮弹出节点的父节点，然后指向父节点的右子节点，继续循环
            //弹出右子节点之后，右子节点的右子节点为空，循环又到了这里，
            //此时弹出的是刚刚右子节点的父节点的父节点，这样保持循环
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


}
