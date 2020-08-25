package com.yanl.leetcode;

/**
 * @author YanL
 * @date 11:00 2020/8/25
 * 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * dp[i][j]表示word1的前i个字符变换成word2的前j个字符所需要的最少操作数
 * 如果word1[i-1] == word2[j-1] dp[i][j] = dp[i-1][j-1]
 * 如果不等需要进行操作
 *      1-> insert  dp[i][j] = dp[i][j-1]+1
 *      2-> delete  dp[i][j] = dp[i-1][j]+1
 *      3-> update  dp[i][j] = dp[i-1][j-1]+1
 *      */

public class L0072EditDistance {
    public int minDistance(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(chars1[i-1] == chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int insert = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int update = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, update));
                }
            }
        }
        return dp[len1][len2];
    }
}
