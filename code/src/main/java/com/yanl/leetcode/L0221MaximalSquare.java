package com.yanl.leetcode;

/**
 * @author YanL
 * @date 22:46 2020/9/5
 * 最大正方形
 * 这个是正方形  =====不是矩形====
 * dp[i][j]表示以i,j为右下角的最大正方形的边长
 * 边长满足dp[i][j] = min(dp[i-1][j], dp[i][j-1],dp[i-1][j-1])
 */
public class L0221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxSideLen = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSideLen = Math.max(maxSideLen, dp[i][j]);
                }
            }
        }
        return maxSideLen * maxSideLen;
    }
}
