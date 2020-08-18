package com.yanl.acm;

import java.util.Scanner;

/**
 * @author YanL
 * @date 16:43 2020/8/18
 * 求一个序列的最大和子序列以及子序列开头和结尾的元素
 * 输出子序列最大和以及开头和结尾的元素
 */
/*
输入
10
-10 1 2 3 4 -5 -23 3 7 -21
 */

public class MaxContinueSequenceWithBoundary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i ++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int left = 0;
        int right = 0;
        int max = 0;
        int[] dp = new int[len];
        dp[0] = arr[0];
        boolean isNeg = false;
        if(arr[0] >= 0){
            isNeg = true;
        }
        for(int i = 1; i < len; i++){
            if(arr[i] >= 0) {
                isNeg = true;
            }
            dp[i] = Math.max(dp[i-1], dp[i-1] + arr[i]);
            if(max < dp[i]){
                max = dp[i];
                right = i;
            }
        }
        if(!isNeg){
            System.out.println(max + " " + arr[0] + " " + arr[len-1]);
        }else{
            int tmp = right;
            while (dp[tmp] > 0){
                tmp--;
            }
            System.out.println(max + " " + arr[left] + " " + arr[right]);
        }
    }
}
