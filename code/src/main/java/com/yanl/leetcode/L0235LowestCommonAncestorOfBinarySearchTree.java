package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 10:32 2020/9/20
 * 二叉搜索树的最近公共祖先
 * 后序遍历  根据数的大小进行判断递归哪一测
 */
public class L0235LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        int pV = p.val;
        int qV = q.val;
        int curV = root.val;
        if(pV > curV && qV > curV){
            return lowestCommonAncestor(root.right, p, q);
        }else if(pV < curV && qV < curV){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return root;
        }
    }
}
