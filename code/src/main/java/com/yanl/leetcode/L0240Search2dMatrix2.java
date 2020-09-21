package com.yanl.leetcode;

/**
 * @author YanL
 * @date 0:36 2020/9/22
 * 搜索二位矩阵
 */
public class L0240Search2dMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i ++){
            for(int j = cols - 1; j >= 0; j --){
                if(matrix[i][j] > target){
                    continue;
                }else if(matrix[i][j] < target){
                    break;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
