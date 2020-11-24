package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

/**
 * @author YanL
 * @date 20:41 2020/11/24
 * L0222 给出一个完全二叉树，求出该树的节点个数。
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 递归可以求解  对于任意一颗二叉树都可以这么做
 * 或者利用完全二叉树的性质   要么左子树和右子树等高  要么两者差1
 * 可以求二叉树的高度  然后再单独遍历左子树或者右子树
 *
 */
public class L0222CountCompleteTreeNodes {
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right)  + 1;
    }
}
