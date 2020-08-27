package com.yanl.six;

import java.util.Scanner;

/**
 * @author YanL
 * @date 14:47 2020/8/27
 */
public class Cube {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                int k = i + 1, l = j + 1;
            }
        }
    }
}
