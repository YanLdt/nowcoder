package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 17:06 2020/9/3
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，
 * 沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 二叉树还是考虑使用递归
 * 计算以每个节点为根节点的的最大路径
 */
public class L0124BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxOfSingleNode(root);
        return res;
    }

    public int getMaxOfSingleNode(TreeNode node) {
        //如果当前节点为空，则其最大值为0
        if (node == null) {
            return 0;
        }
        //左子节点的最大值
        int left = Math.max(getMaxOfSingleNode(node.left), 0);
        //右子节点的最大值
        int right = Math.max(getMaxOfSingleNode(node.right), 0);

        int curMax = node.val + left + right;
        //更新结果的最大值，以当前节点为根节点的最大值为 node.val + left + right
        res = Math.max(res, curMax);
        //向上层节点返回当前节点的最大值
        return node.val + Math.max(left, right);
    }
}
