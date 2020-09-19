package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 10:23 2020/9/19
 * 反转二叉树
 */
public class L0226InverseBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        //将当前节点的左右子节点进行交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //然后递归交换左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
