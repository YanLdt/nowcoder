package com.yanl.didi;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:54 2020/8/21
 * 这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
 * 下面是n=4时的情况：
 * 小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
 * 单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
 * 输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
 * 3
 * 34 21 13
 * 1 1 8
 * 2 3 5
 * 填充旋转矩阵 常规题
 */
public class Snake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n*n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        long[][] m = new long[n][n];
        snake(m, nums);
        for(long[] a : m){
            for(long b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static void snake(long[][] matrix, long[] nums){
        int index = nums.length - 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom){
            for(int col = left; col <= right; col++){
                matrix[top][col] = nums[index];
                index--;
            }
            for(int row = top + 1; row <= bottom; row++){
                matrix[row][right] = nums[index];
                index--;
            }
            if(left < right && top < bottom){
                for(int col = right - 1; col > left; col--){
                    matrix[bottom][col] = nums[index];
                    index--;
                }
                for(int row = bottom; row > top; row--){
                    matrix[row][left] = nums[index];
                    index--;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}
