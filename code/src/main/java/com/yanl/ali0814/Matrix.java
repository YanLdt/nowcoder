package com.yanl.ali0814;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:03 2020/8/14
 *
 * 返回值必long
 *
 * 小强的梦中出现了一个N * N的矩形，矩形中的每个位置都有一个数字
 * 现在小强可以让其中的某个数字加上d
 * 他想知道最少需要几步才能让整个矩形中的元素相等
 * 或者这根本是不可能的
 *
 * 第一行两个整数 N, d
 * 接下来N行，每行N个整数表示矩形
 *
 * 输出一个整数表示答案
 * 若不存在合法的方案，则输出-1
 * 否则输出最少的操作数
 *
 * 2 1
 * 1 2
 * 3 4
 * 6
 */
public class Matrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        if(n <= 0){
            System.out.println(-1);
            return;
        }
        if(n == 1){
            System.out.println(0);
            return;
        }
        if(d == 0){
            System.out.println(-1);
            return;
        }
        int[][] matrix = new int[n][n];
        int max = 0;
        long count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int tmp = sc.nextInt();
                if(max < tmp){
                    max = tmp;
                }
                matrix[i][j] = tmp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((max - matrix[i][j]) % d != 0){
                    System.out.println(-1);
                    return;
                }
                count += (max - matrix[i][j])/d;
            }
        }
        System.out.println(count);
    }
}
