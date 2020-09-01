package com.yanl.pdd0901;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:06 2020/9/1
 * 炎炎夏日，多多实在太无聊了，唯有学习才能保持内心的安宁。
 *
 * 多多最近在学习矩阵知识，但他遇到了一类奇怪的矩阵。因此想把矩阵打印出来，好好观察。
 *
 * 对于一个n阶矩阵，首先用米字形分割线把矩阵等分为8个区域，然后从右上角开始，
 * 按逆时针顺序给各区域编号为1，2，...，8。如图示意：
 * i=j/i+j=n-1
 * n % 2 != 0  n / 2 行列均为0
 * 从左上角开始遍历
 */
public class Matrix {
    static int number = 1;
    static int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean flag = false;
        if(n % 2 != 0){
            flag = true;
        }
        int[][] matrix = new int[n][n];
        setMatrix(matrix, n, flag);
        for(int[] a : matrix){
            for(int i = 0; i < n; i++){
                System.out.print(a[i]);
                if(i != n-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void setMatrix(int[][] matrix, int n, boolean flag){
        int cols = n;
        int rows = n;
        int left = 0;
        int right = cols - 1;
        int up = 0;
        int down = rows-1;
        while (true){
            //向左
            for(int i = right; i >= left; i--){
                if(i == up || i + up == n - 1 || (flag && i == n / 2)){
                    matrix[up][i] = 0;
                }else if(i >= n / 2){
                    matrix[up][i] = 1;
                }else {
                    matrix[up][i] = 2;
                }
            }
            if(up++ > down){
                break;
            }
            //向下
            for(int i = up; i <= down; i ++){
                if(i == left || i + left == n - 1 || (flag && i == n / 2)){
                    matrix[i][left] = 0;
                }else if(i < n / 2){
                    matrix[i][left] = 3;
                }else {
                    matrix[i][left] = 4;
                }
            }
            if(left++ > right){
                break;
            }
            //向右
            for(int i = left; i <= right; i ++){
                if(i == down || i + down == n - 1 || (flag && i == n / 2)){
                    matrix[down][i] = 0;
                }else if(i < n / 2){
                    matrix[down][i] = 5;
                }else {
                    matrix[down][i] = 6;
                }
            }
            if(down-- < up){
                break;
            }
            //向上
            for(int i = down; i >= up; i--){
                if(i == right || i + right == n - 1 || (flag && i == n / 2)){
                    matrix[i][right] = 0;
                }else if(i >= n / 2){
                    matrix[i][right] = 7;
                }else {
                    matrix[i][right] = 8;
                }
            }
            if(right-- < left){
                break;
            }
        }
    }
}
