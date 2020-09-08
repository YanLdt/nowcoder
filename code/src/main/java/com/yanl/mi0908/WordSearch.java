package com.yanl.mi0908;

import java.util.Scanner;

/**
 * @author YanL
 * @date 18:46 2020/9/8
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,
 * 同一个单元格内的字母不允许被重复使用。
 *
 * [
 *
 *   ['A','B','C','E'],
 *
 *   ['S','F','C','S'],
 *
 *   ['A','D','E','E']
 *
 * ]
 */
public class WordSearch {
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();
        char[][] matrix = new char[][]{
            {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
        };
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(dfs(word, matrix, i, j, 0)){
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");

    }

    public static boolean dfs(String word, char[][] matrix, int i, int j, int curIndex){
        if(curIndex == word.length()){
            flag = true;
            return true;
        }
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || word.charAt(curIndex) != matrix[i][j]){
            return false;
        }
        if(!flag){
            char tmp = matrix[i][j];
            matrix[i][j] = '.';
            boolean res1 = dfs(word, matrix, i + 1, j, curIndex + 1);
            boolean res2 = dfs(word, matrix, i - 1, j, curIndex + 1);
            boolean res3 = dfs(word, matrix, i, j + 1, curIndex + 1);
            boolean res4 = dfs(word, matrix, i, j - 1, curIndex + 1);
            matrix[i][j] = tmp;
            return res1 || res2 || res3 || res4;
        }else {
            return true;
        }
    }
}
