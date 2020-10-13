package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanL
 * @date 21:52 2020/10/13
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，
 * 返回矩阵中的所有元素。
 */
public class L0054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom){
            for(int c = left; c <= right; c ++){
                res.add(matrix[top][c]);
            }
            for(int r = top + 1; r <= bottom; r ++){
                res.add(matrix[r][right]);
            }
            if(left < right && top < bottom){
                for(int c = right - 1; c > left; c --){
                    res.add(matrix[bottom][c]);
                }
                for(int r = bottom; r > top; r --){
                    res.add(matrix[r][left]);
                }
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }
        return res;
    }
}
