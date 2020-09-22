package com.yanl.leetcode;

/**
 * @author YanL
 * @date 13:45 2020/9/22
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 动规dp[i]表示和为i的所需要的最少完全平方数的个数
 * dp[i] = i
 *
 * dp[i] = Math.max(dp[i], dp[i-j*j]+1)
 *
 */
public class L0279PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n;  i++){
            //每次最坏情况就是i个1
            dp[i] = i;
            //然后遍历找出最小的
            for(int j = 1; i - j * j >= 0; j ++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
