package com.yanl.baidu0903;

import java.util.Scanner;

/**
 * @author YanL
 * @date 20:54 2020/9/3
 * n个台阶
 * 单步最多m个台阶，最少跨1个台阶
 * 每步和之前两部走的台阶数目不同
 * 有多少种不同走法
 */
public class Stair {

    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int pre1 = -1;
        int pre2 = -1;
        dfs(0, pre1, pre2, m, n);
        System.out.println(res);
    }

    /**
     * 暴力美学  这两个pre1,pre2是真的巧妙
     * @param cur
     * @param pre1
     * @param pre2
     * @param m
     * @param n
     */
    public static void dfs(int cur, int pre1, int pre2, int m, int n){
        if(cur == n){
            res++;
            return;
        }
        for(int i = 1; i <= m; i ++){
            if(pre1 != i && pre2 != i){
                dfs(cur+i, pre2, i, m, n);
            }
        }
    }
}
