package com.yanl.huawei0909;

import java.util.Arrays;

/**
 * @author YanL
 * @date 19:12 2020/9/9
 */
public class WaterPoll {

    static int res = 0;
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {8, 4, 1},
                {6, 5, 2}
        };
        //System.out.println(Arrays.deepToString(matrix));
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                dfs(matrix, i, j, Integer.MAX_VALUE, 1);
            }
        }
        System.out.println(res);
    }

    public static void dfs(int[][] matrix, int i, int j, int pre, int count){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix.length){
            return;
        }
        if(pre < matrix[i][j]){
            res = Math.max(res, count);
            return;
        }
        if(pre > matrix[i][j]){
            count++;
        }
        int tmp = matrix[i][j];
        pre = tmp;
        matrix[i][j] = Integer.MAX_VALUE;
        dfs(matrix, i + 1, j, pre, count);
        dfs(matrix, i - 1, j, pre, count);
        dfs(matrix, i, j + 1, pre, count);
        dfs(matrix, i, j - 1, pre, count);
        matrix[i][j] = tmp;
    }
}
