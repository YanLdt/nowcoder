package com.yanl.leetcode;

/**
 * @author YanL
 * @date 0:31 2020/9/15
 * 最长公共子序列
 * dp[i][j]是以a[i],b[j]结尾的子串最长公共子序列
 * 如果a[i] = b[j] dp[i+1][j+1] = dp[i][j]
 * 如果不等于 dp[i+1][j+1] = max(dp[i][j+1],dp[i+1][j]
 *
 */
public class L1143LongestCommonSubSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i < len1; i ++){
            for(int j = 0; j < len2; j ++){
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if(c1 == c2){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
