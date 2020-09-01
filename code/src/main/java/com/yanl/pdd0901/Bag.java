package com.yanl.pdd0901;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:44 2020/9/1
 *  背包问题
 *  物品空间和价值可以为负，负物品增大背包，负价值减小收益
 *
 */
public class Bag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] c = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] dp = new int[M+1];
        for(int i = 1; i <= N; i ++){
            for(int j = M; j >= c[i-1]; j --){
                dp[j] = Math.max(dp[j], dp[j - c[i-1]] + v[i-1]);
            }
        }
        System.out.println(dp[M]);
    }
}
