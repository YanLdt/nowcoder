package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.*;

/**
 * @author YanL
 * @date 14:09 2020/9/2
 * 二叉树后序遍历
 */
public class L0145BinaryTreePostOrderTraversal {
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    /**
     * 递归后序遍历
     * @param root
     * @param res
     */
    public void recursive(TreeNode root, List<Integer> res){
        if(root != null){
            recursive(root.left, res);
            recursive(root.right, res);
            res.add(root.val);
        }
    }

    /**
     * 左右中反过来是中右左，即可以把先序遍历改一个顺序
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.left != null){
                stack.push(tmp.left);
            }
            if(tmp.right != null){
                stack.push(tmp.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}

