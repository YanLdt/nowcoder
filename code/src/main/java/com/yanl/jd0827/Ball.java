package com.yanl.jd0827;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:34 2020/8/27
 * 某滚球游戏规则如下：球从入口处（第一层）开始向下滚动，每次可向下滚动一层，直到滚至最下面一层为止。
 * 球每次可滚至左下、下方或右下三个方格中的任意一个，每个方格都有一个得分，如下图所示。第1层有1个方格，
 * 第2层有3个方格，……，以此类推，第n层有2*n-1个方格。设计一个算法，使得球从入口滚至最下面一层的总得分和最大。
 * dp[i][j]表示球到达第[i][j]位置得到的最大分
 * dp[i][j] = max(dp[i+1][j],dp[i+1][j+1],dp[i+1][j+2]) + arr[i][j]
 */
public class Ball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][2*n+2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2 * i; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;

        int[][] dp = new int[n+1][2*n+2];
        for(int i = 0; i <= 2 * n - 1; i ++){
            dp[n-1][i] = arr[n-1][i];
        }
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 2 * i; j++){
                dp[i][j] = Math.max(dp[i+1][j], Math.max(dp[i+1][j+1], dp[i+1][j+2])) + arr[i][j];
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
