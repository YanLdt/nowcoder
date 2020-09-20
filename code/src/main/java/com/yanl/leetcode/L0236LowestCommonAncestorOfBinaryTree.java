package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 10:08 2020/9/20
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * 做一个后序遍历， 递归左右子节点
 */
public class L0236LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        //当节点等于pq的时候直接返回节点
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左右节点返回值为都不为空，说明在pq分布在两侧，返回root
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else {
            return right;
        }
    }
}
