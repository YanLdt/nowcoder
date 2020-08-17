package com.yanl.bag;

import java.util.Scanner;

/**
 * @author YanL
 * @date 11:08 2020/8/17
 */
public class AbsoluteBag {
    /**
     * 完全背包问题
     *
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for(int i = 0; i < N; i ++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[] dp = new int[V+1];
        for(int i = 1; i <= N; i ++){
            //这边使用顺序遍历，即上一轮放过的物品可以再次放进去
            //倒序是保证每件物品只出现一次，而现在又无限物品，可以重复，
            // 因此从前向后遍历可以得到一种添加了已选第i种物品的结果
            for(int j = v[i-1]; j <= V; j ++){
                dp[j] = Math.max(dp[j], dp[j - v[i-1]] + w[i-1]);
            }
        }
        System.out.println(dp[V]);
    }
}
