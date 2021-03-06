package com.yanl.monkey;

import java.util.Scanner;

/**
 * @author yanl
 */
public class Maze {
    /**
     * 有一个N*M大小的迷宫矩阵，迷宫的每一个格子有一个数值（a[i][j] <10^9）。
     * 小猿在迷宫中发现，它只能朝着上下左右四个方向的相邻格子前进，并且只能进入比当前位置数值更大的格子。
     * 但是小猿有个紧急呼救按钮，他可以通过按下按钮，强行进入到不满足数值大小要求的相邻格子，可惜这个按钮只能按K次。
     * 请问小猿从这个迷宫任选一个格子出发，在紧急呼救按钮的帮助下，最多能走多少步
     * （开始位置计入步数，即站在起点是步数为1）。
     * 输入描述:
     * 第一行输入三个数N, M, K。接下来N行，每行M个数，表示迷宫中每个格子的值。
     * 1 ≤ N ≤ 500
     * 1 ≤ M ≤ 500
     * 0 ≤ K ≤ 10
     *
     * 输出描述:
     * 输出小猿在迷宫中能走的最大步数
     *
     * 输入例子1:
     * 3 3 1
     * 1 3 3
     * 2 4 9
     * 8 9 2
     *
     * 输出例子1:
     * 6
     *
     * 例子说明1:
     * 其中一种行走方案： (0, 0) -> (0, 1) -> (0, 0) -> (1, 0) -> (2, 0) -> (2, 1)
     *
     * @param args 主程序参数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int k = sc.nextInt();
        int[][] nums = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int[][][] dp = new int[row][col][k+1];
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                max = Math.max(max, dfs(nums, k, dp, i, j, Integer.MIN_VALUE));
            }
        }
        System.out.println(max);

    }

    /**
     * 递归，使用三维数组存储信息dp[i][j][k]表示在矩阵中位于I,J的点拥有K次机会所能走的最大步数
     * @param nums 矩阵
     * @param k 按钮
     * @param dp 存储结果的数组
     * @param row 当前行
     * @param col 当前列
     * @param cur 当前点周围的最大值 小于该值则需要按钮
     * @return 返回步数
     */
    public static int dfs(int[][] nums, int k, int[][][] dp, int row, int col, int cur) {
        int rowMax = nums.length;
        int colMax = nums[0].length;

        if(row < 0 || col < 0 || row >= rowMax || col >= colMax){
            return 0;
        }
        int tmp;
        if((tmp = nums[row][col]) <= cur){
            if(k == 0){
                return 0;
            }
            k--;
        }
        if(dp[row][col][k] != 0){
            return dp[row][col][k];
        }
        int max = dfs(nums, k, dp, row - 1, col, tmp);
        max = Math.max(max, dfs(nums, k, dp, row + 1, col, tmp));
        max = Math.max(max, dfs(nums, k, dp, row, col - 1, tmp));
        max = Math.max(max, dfs(nums, k, dp, row, col + 1, tmp));
        max++;
        dp[row][col][k] = max;
        return max;
    }

}
