package com.yanl.leetcode;

/**
 * @author YanL
 * @date 16:58 2020/9/1
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class L0079WordSearch {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        int curIndex = 0;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(dfs(board, i, j, word, curIndex)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深搜
     * @param board
     * @param i
     * @param j
     * @param word
     * @param curIndex
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, String word, int curIndex){
        if(curIndex == word.length()){
            flag = true;
            return true;
        }
        //判断是否在边界内 以及能都匹配
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(curIndex)){
            return false;
        }
        if(!flag){
            char c = board[i][j];
            //防止重复搜索
            board[i][j] = '.';
            boolean res1 = dfs(board, i + 1, j, word, curIndex + 1);
            boolean res2 = dfs(board, i - 1, j, word, curIndex + 1);
            boolean res3 = dfs(board, i, j + 1, word, curIndex + 1);
            boolean res4 = dfs(board, i, j - 1, word, curIndex + 1);
            //深搜之后把字符重置回原来状态
            //DFS前后必须要保证执行前后程序面对问题的状态是相同的，
            //因此当前问题缩小为子问题时所做的对当前问题状态产生影响的事情应该全部失效
            board[i][j] = c;
            return res1 || res2 || res3 || res4;
        }else {
            return true;
        }
    }
}
