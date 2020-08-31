package com.yanl.leetcode;

/**
 * @author YanL
 * @date 16:17 2020/8/31
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 先上下反转，然后再沿对角线反转
 */
public class L0048RotateImage {
    public void rotate(int[][] matrix) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high){
            int[] tmp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = tmp;
            low++;
            high--;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for(int j = i; j < col; j++){
                if(j != i){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }
}
