package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanL
 * @date 10:32 2020/9/26
 * 路径总和2
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class L0113PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int subSum = 0;
        dfs(root, 0, res, new ArrayList<>());
        return res;
    }

    public static void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> sub){
        if(root == null){
            return;
        }
        sub.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val){
                res.add(new ArrayList<>(sub));
            }
            sub.remove(sub.size() - 1);
            return;
        }
        dfs(root.left, sum-root.val, res, sub);
        dfs(root.right, sum-root.val, res, sub);
        sub.remove(sub.size() - 1);
    }
}
