package com.yanl.leetcode;

/**
 * @author YanL
 * @date 11:29 2020/8/25
 * 给定一个只包含0，1的二位二进制矩阵，找出只包含1的最大矩形，并返回其面积
 * dp[i][j]表示以i，j结尾的矩形的最大高度
 */
public class L0085MaximumRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                                        {'1','0','1','1','1'},
                                        {'1','1','1','1','1'},
                                        {'1','0','0','1','0'}};
        System.out.println(new L0085MaximumRectangle().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix){
        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        //把原数组放入dp数组
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1;
                }
            }
        }
        //累计每一个单元格所能向上延伸的长度，类似于压缩
        for(int i = 1; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(dp[i - 1][j] >= 1){
                    if(dp[i][j] == 1){
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(dp[i][j] == 0){
                    continue;
                }
                int curHeight = dp[i][j];
                for(int k = j; k >= 0 && dp[i][k] != 0; k--){
                    int curWidth = j - k + 1;
                    //每次更新当前高度为最低值
                    curHeight = Math.min(curHeight, dp[i][k]);
                    res = Math.max(res, curHeight * curWidth);
                }
            }
        }
        return res;
    }
}
