package com.yanl.ebay;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:40 2020/10/16
 */
public class NumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < m; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for(int j = a - 1; j < b; j ++){
                res[j] += c;
            }
        }
        for(int i : res){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i ++){
            System.out.print(res[i]);
            if(i != n - 1){
                System.out.print(" ");
            }
        }
    }
}
