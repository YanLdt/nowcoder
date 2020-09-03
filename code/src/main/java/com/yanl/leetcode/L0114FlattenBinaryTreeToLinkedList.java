package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author YanL
 * @date 15:35 2020/9/3
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 类似于先序遍历
 * 先序遍历后得到每个元素的访问顺序
 * 按照访问顺序重新构建二叉树
 * 前一个节点的左子节点始终为空，右子节点为下一个节点
 */
public class L0114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode res = root;
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (res != null || !stack.isEmpty()){
            while (res != null){
                list.add(res);
                stack.push(res);
                res = res.left;
            }
            res = stack.pop();
            res = res.right;
        }
        int len = list.size();
        for(int i = 1; i < len; i ++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    /**
     * 递归，展开为  中->左->右,右子树应该放在左子树的最后一个节点的右子节点上
     * 所以先将左子树展开，再展开右子树，将左子树移到右子树的地方
     * 再将原来的左子树置空，
     * @param root
     */
    public void recursive(TreeNode root){
        if(root == null){
            return;
        }
        //展开左子树
        flatten(root.left);
        //展开右子树
        flatten(root.right);
        //存储右子树
        TreeNode tmp = root.right;
        //将左子树挂在右边
        root.right = root.left;
        //将左子树清空
        root.left = null;
        //找到当前右子树的最右边节点
        while (root.right != null){
            root = root.right;
        }
        //找到最右边的节点之后把之前保存的右节点挂在后面
        root.right = tmp;
    }
}
