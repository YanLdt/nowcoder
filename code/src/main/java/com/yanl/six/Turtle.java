package com.yanl.six;

import java.util.Scanner;

/**
 * @author YanL
 * @date 21:00 2020/8/23
 * 乌龟棋
 * 第一行 两个正整数N,M,表示棋盘格子数和爬行卡片数
 * 第二行 N个非负整数，a[i]表示棋盘上第i个格子上的分数
 * 第三行M个整数，表示M张爬行卡片的数字
 * 保证刚好用完M张爬行卡片
 */
public class Turtle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //记录棋盘上的分数
        int[] score = new int[n+10];
        for(int i = 0; i < n; i++){
            score[i] = sc.nextInt();
        }
        //记录四种卡片的张树[1, 2, 3 , 4]
        int[] card = new int[5];
        for(int i = 1; i <= m; i++){
            card[sc.nextInt()]++;
        }
        //动态规划：表示dp[i][j][k][l]表示拿了i张1，j张2，k张3，l张4时所得到的最大分数
        //状态转移方程：
        // dp[i][j][k][l]=
        // max(dp[i-1][j][k][l],dp[i][j-1][k][l],dp[i][j][k-1][l],dp[i][j][k][l-1]) + score(i+2*j+3*k+4*l)
        //
        int[][][][] dp = new int[41][41][41][41];
        //初始化：dp[0][0][0][0]=score[0],此时在起点
        dp[0][0][0][0] = score[0];
        for(int i = 0; i <= card[1]; i++){
            for(int j = 0; j <= card[2]; j++){
                for(int k = 0; k <= card[3]; k++){
                    for(int l = 0; l <= card[4]; l++){
                        int a = 0, b = 0, c = 0, d = 0;
                        if(i > 0){
                            a = dp[i-1][j][k][l];
//                            dp[i][j][k][l] = Math.max(dp[i][j][k][l], dp[i-1][j][k][l]);
                        }
                        if(j > 0){
                            b = dp[i][j-1][k][l];
//                            dp[i][j][k][l] = Math.max(dp[i][j][k][l], dp[i][j-1][k][l]);
                        }
                        if(k > 0){
                            c = dp[i][j][k-1][l];
//                            dp[i][j][k][l] = Math.max(dp[i][j][k][l], dp[i][j][k-1][l]);
                        }
                        if(l > 0){
                            d = dp[i][j][k][l-1];
//                            dp[i][j][k][l] = Math.max(dp[i][j][k][l], dp[i][j][k][l-1]);
                        }
                        dp[i][j][k][l] = Math.max(Math.max(a, b), Math.max(c, d)) + score[i+2*j+3*k+4*l];
                    }
                }
            }
        }
        System.out.println(dp[card[1]][card[2]][card[3]][card[4]]);
    }
}
