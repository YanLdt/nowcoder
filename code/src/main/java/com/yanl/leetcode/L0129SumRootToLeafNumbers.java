package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 10:02 2020/10/29
 * 求根到叶子节点的数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 */
public class L0129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root){
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int tmp){
        if(root == null){
            return 0;
        }
        int sum = tmp * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
