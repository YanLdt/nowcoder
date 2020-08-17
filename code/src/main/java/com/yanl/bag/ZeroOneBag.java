package com.yanl.bag;

import java.util.Scanner;

/**
 * @author YanL
 * @date 21:56 2020/8/16
 * N件物品和一个容量为V的背包，每件物品只能使用一次
 * 第i件物品的体积为Vi,价值为Wi
 * 求解将那些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大，输出最大价值
 * 输入格式
 * 第一行两个整数，N,V，分别表示物品数量和背包容积
 * 接下来N行，每行两个整数Vi,Wi，分别表示第i件物品的体积和价值
 * 输出
 * 输出一个整数，表示最大价值
 *
 * 定义dp[i][j]表示前i个物品，背包容量为j下的最优解
 *
 */
public class ZeroOneBag {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for(int i = 0; i < N; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int [][] dp = new int[N+1][V+1];
        for(int i = 1; i < N; i++){
            for(int j = 1; j <= V; j ++){
                if(j < v[i-1]){
                    //装不下当前重量，则价值等于前i-1物品的价值
                    dp[i][j] = dp[i-1][j];
                }else {
                    //装得下第i件物品
                    //应为两者较大值
                    // 1-不装第i件物品的最大价值
                    // 2-装第i件商品的最大价值：先把第i件物品除去，求剩余j-v[i]体积下装i-1商品的最大价值  再加上第i件物品的价值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i-1]] + w[i-1]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }

    /**
     * 空间优化
     * 一定要注意i-1才是第i个物品
     * 该题v为体积
     * w为价值
     * 搞得我都晕了
     * 为什么不是重量w和价值v
     * @param v
     * @param w
     * @param N
     * @param V
     * @return
     */
    public int optimizedBag(int[] v, int[] w, int N, int V){
        int[] dp = new int[V+1];
        for(int i = 1; i <= N; i ++){
            //注意这里一定要倒着遍历，f[j]整个数组都是由上一个状态转换过来的，保证每件物品只能选择0次或者1次
            //如果从前往后遍历，会导致当前状态后面的值是由当前状态前面的值得出来的。
            //当前状态的值应该有上一个状态的值转换过来。
            for(int j = V; j >= v[i-1]; j --){
                dp[j] = Math.max(dp[j], dp[j-v[i-1]] + w[i-1]);
            }
        }
        return dp[V];
    }
}
