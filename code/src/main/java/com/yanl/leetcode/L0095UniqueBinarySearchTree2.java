package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author YanL
 * @date 9:54 2020/8/24
 * 给一个整数n,生成所有由1-n为节点所组成的二叉搜索树
 * 将数组还是分为两部分1-i-1,i+1-n
 * 然后递归生成两个子序列的搜索树集合
 * 之后从两个集合各任取进行组合
 */
public class L0095UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n){
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return helper(1, n);
    }

    /**
     * 递归生成所有树集合
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new LinkedList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        //枚举所有根节点
        for(int i = start; i <= end; i++){
            //获得所有可行的左子树集合
            List<TreeNode> left = helper(start, i - 1);
            //获取所有可行的右子树集合
            List<TreeNode> right = helper(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
