package com.yanl.shenxinfu;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:31 2020/8/25
 *
 */
public class TreeGrow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        //原始数组
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            min = Math.min(arr[i], min);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += arr[i] - min;
        }

        System.out.println(res);
    }
}
