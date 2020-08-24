package com.yanl.leetcode;

/**
 * @author YanL
 * @date 14:47 2020/8/24
 * 一堆石子排场一行，每个石子有一个关联值
 * 游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；
 * Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最大的行，
 * Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。
 * 下一轮从剩下的那一行开始。
 * 只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。
 * 返回 Alice 能够获得的最大分数 。
 * 使用区间dp dp[i][j]表示[i,j]区间的Alice取得的最大值
 * [i ***** m ***** j]
 * 状态转移过程：
 * 枚举每个m点，左右两堆能获取的最大值分别为dp[i][m],dp[m+1][j]
 * 如果[i,m]区间价值和等于[m+1,j]区间和，则最大分数为max(dp[i][m],dp[m+1][j]) + 相等的区间价值和
 * 如果不相等，则只能取小的区间，
 *
 */
public class L1563StoneGameV {
    public int stoneGame(int[] stoneValue){
        int n = stoneValue.length;
        int[][] dp = new int[n][n];

        //计算0-i区间和
        int[] preSum = new int[n];
        preSum[0] = stoneValue[0];
        for(int i = 1; i < n; i++){
            preSum[i] = stoneValue[i] + preSum[i-1];
        }
        //外层为区间长度，区间最少为2
        for(int len = 2; len <= n; len++){
            //这层为区间初始值i
            for(int i = 0; i + len <= n; i++){
                //j为区间末尾值
                int j = i + len - 1;
                //计算[i,j]小区间
                for(int m = i; m < j; m++){
                    //左区间的和
                    int left = preSum[m] -(i > 0 ? preSum[i-1] : 0);
                    //右区间的和
                    int right = preSum[j] - preSum[m];
                    //如果两个区间和相等，则让其自己选，则选两个区间所能拿到的最大值即Math.max(dp[i][m], dp[m+1][j])
                    if(left == right){
                        int s = Math.max(dp[i][m], dp[m+1][j]) + left;
                        dp[i][j] = Math.max(dp[i][j], s);
                    }else {
                        //两个区间不相等需要选择和较小的区间
                        dp[i][j] = left > right ? Math.max(dp[m+1][j] + right, dp[i][j])
                                : Math.max(dp[i][m] + left, dp[i][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
