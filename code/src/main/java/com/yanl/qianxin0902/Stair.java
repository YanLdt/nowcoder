package com.yanl.qianxin0902;

import java.util.Scanner;

/**
 * @author YanL
 * @date 15:42 2020/9/2
 *
 */
public class Stair {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0 || n > 36){
            System.out.println(0);
            return;
        }
        if(n == 0 || n == 1){
            System.out.println(1);
            return;
        }
        sc.close();
        System.out.println(fc(n));
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i = 3; i <= n; i ++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        System.out.println(dp[n]);
    }

    public static int fc(int n){
        if(n == 1 || n == 2){
            return n;
        }else {
            res = fc(n-1) + fc(n-2);
        }
        return res;
    }
}
