package com.yanl.leetcode;

/**
 * @author YanL
 * @date 1:07 2020/9/14
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 当作无向图来做
 * 遇到1则深搜，搜索到1置为0
 * 岛屿的个数就是深搜的次数
 */
public class L0200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        int res = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        grid[i][j] = '0';
        //如果满足一下条件则继续深搜
        if(i - 1 >= 0 && grid[i-1][j] == '1'){
            dfs(grid, i - 1, j);
        }
        if(i + 1 < row && grid[i+1][j] == '1'){
            dfs(grid, i + 1, j);
        }
        if(j - 1 >= 0 && grid[i][j-1] == '1'){
            dfs(grid, i, j - 1);
        }
        if(j + 1 < col && grid[i][j+1] == '1'){
            dfs(grid, i, j + 1);
        }
    }
}
