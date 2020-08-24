package com.yanl.leetcode;

/**
 * @author YanL
 * @date 15:42 2020/8/24
 * 最长回文字符串
 * 找出给定字符串中最长的回文子串
 * 动态规划
 * 使用dp[i][j]表示[i,j]区间是否为回文字符串
 * dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
 * dp[i][i] = true;
 */
public class L0005LongestPalindromeString {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        //注意这里一定要设为1  因为第一个字符一定是一个回文的，所以在后面没有回文字符串的情况下，需要输出第一个字符
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //这边因为参数设反了所以下面的转移方程需要改动
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    //这里是正常情况下 i - 1 应该是大于 j + 1的，i-1-(j+1) + 1>2 ->j-i+1<4
                    //区间为2 3时，只需要判断两端相同即可
                    if(i - j < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
