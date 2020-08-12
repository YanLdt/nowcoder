package com.yanl.bilibili;

import java.util.Scanner;

/**
 * @author YanL
 * @date 23:42 2020/8/12
 * 有为N件物品，它们的重量w分别是w1,w2,...,wn，
 * 它们的价值v分别是v1,v2,...,vn，每件物品数量有且仅有一个，
 * 现在给你个承重为M的背包，求背包里装入的物品具有的价值最大总和？
 *
 * 物品数量N=5件
 * 重量w分别是2 2 6 5 4
 * 价值v分别是6 3 5 4 6
 * 背包承重为M=10
 *
 * 背包内物品最大总和为15
 *
 * 5
 * 10
 * 2 2 6 5 4
 * 6 3 5 4 6
 *
 * 15
 * 考虑第i件物品放还是不放
 * 不放的话则考虑前i-1件装满背包
 * 放的话考虑前i-1件装满m-m[i] 最大为f[i-1][m-m[i]] + v[i]
 * 状态转移方程 f[i][m] = max{f[i-1][m], f[i-1][m-m[i]] + v[i]}
 *
 */

public class Bag {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
        }
        int[][] dp = new int[N][M+1];

        //初始化1件物品,填表格第一行
        int i = 0, j = 0;
        for(j = 1; j <= M; j++){
            if(j < w[i]){
                dp[i][j] = 0;
            }else {
                dp[i][j] = v[i];
            }
        }
        //填下面的n-1行
        for( i = 1; i < N; i++){
            for(j = 1; j <= M; j++){
                if(j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-w[i]], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
