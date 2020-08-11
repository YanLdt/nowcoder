package com.yanl.offer;

/**
 * @author YanL
 * @date 11:01 2020/8/10
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 */
public class IsBalancedTree  {
    private boolean isBalanced = true;
    public boolean idBalancedTree(TreeNode root){
        int depth = getDepth(root);
        return isBalanced;
    }

    /**
     * 获取左右子树深度并判断是否平衡
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
