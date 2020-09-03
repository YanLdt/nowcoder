package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 */
public class L0104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getDepth(root);
    }

    public int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftD = getDepth(node.left);
        int rightD = getDepth(node.right);
        return Math.max(leftD, rightD) + 1;
    }
}
