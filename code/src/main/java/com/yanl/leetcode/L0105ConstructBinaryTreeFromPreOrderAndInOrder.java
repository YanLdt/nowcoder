package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 10:48 2020/9/3
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 重建二叉树
 * 注意边界  注意边界  注意边界   注意边界   注意边界
 */
public class L0105ConstructBinaryTreeFromPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return build(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int root = preorder[preStart];
        int rootIndex = inStart;
        //这里将中序数组分为三个部分
        //inStart,rootIndex,inEnd
        //分别为左子树的中序[inStart, rootIndex-1]，根节点，右子树的中序[rootIndex+1, inEnd]
        //也将先序数组分为三个部分
        //rootIndex,
        // 前半部分为左子树的先序，起始点为preStart+1,数组长度为 rootIndex - inStart,
        // 后半部分为右子树的先序，数组长度为 inEnd-rootIndex
        for(int i = inStart; i < inEnd; i ++){
            if(inorder[i] == root){
                rootIndex = i;
            }
        }
        TreeNode res = new TreeNode(root);
        res.left = build(preorder, preStart+1, preStart + rootIndex - inStart,
                inorder, inStart, rootIndex - 1);
        res.right = build(preorder, preStart + rootIndex - inStart + 1,
                preEnd, inorder, rootIndex + 1, inEnd);
        return res;
    }
}
