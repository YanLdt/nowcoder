package com.yanl.leetcode;

/**
 * @author YanL
 * @date 1:04 2020/8/24
 * 给一个整数，求以1-n为节点组成的二叉搜索树有多少种
 * 定义f(i)代表n个节点以i为根节点的二叉搜索树的个数，g(n)代表n个节点组成的二叉搜索树的个数
 * g(n) = f(1) + f(2) + ... + f(n)
 * 当i为根节点是，左边有i-1个节点，右边有n-i个节点
 * f(i) = g(i-1)*g(n-i)
 * =>g(n) = g(0)*g(n-1) + g(1)*g(n-2) + .... + g(n-1)*g(0)
 */
public class L0096UniqueBinarySearchTree {
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //外层循环是节点数
        for(int i = 2; i < n + 1; i ++){
            //内层循环是计算当前i个节点存在的二叉搜索树的个数
            for(int j = 1; j < i + 1; j ++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
