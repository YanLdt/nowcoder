package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 验证搜索二叉树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。\
 * 中序遍历一下，判断前一个元素是否小于后一个元素   左中右
 */
public class L0098ValidateBinarySearchTree {
    public boolean isValidBst(TreeNode root) {
        if(root == null){
            return false;
        }
        return inOrder(root);
    }

    public boolean isValid(TreeNode root){
        if(root == null){
            return true;
        }
        if((root.left!= null) && isValid(root.left) && (root.right != null) && isValid(root.right)){
            return root.left.val < root.val && root.val < root.right.val;
        }
        return false;
    }

    public boolean inOrder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        long tmp = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            //比较当前值与上一个值的大小，如果当前值小于上一个值的话则不是二叉搜索树
            if(tmp > cur.val){
                return false;
            }
            tmp = root.val;
            cur = cur.right;
        }
        return true;
    }
}
