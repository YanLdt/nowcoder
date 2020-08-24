package com.yanl.leetcode;

/**
 * @author YanL
 * @date 17:09 2020/8/24
 * 正则表达式
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * dp[i][j]表示字符串前i个字符与正则串前j个字符是否匹配
 * 此时判断前i-1个字符与前j-1个字符
 * 1-p[j] == s[i] -->  dp[i][j] = dp[i-1][j-1]
 * 2-p[j] == '.'  -->  dp[i][j] = dp[i-1][j-1]
 * 3-p[j] == '*'  -->
 *    p[j-1] != s[i] --->  此时需要看前j-2个字符是否能匹配S串 dp[i][j] = dp[i][j-2]
 *    p[j-1] == s[i] || p[j-1] == '.'
 *      1->如果放弃匹配的话  ->就相当于把'x*'两个字符去掉 dp[i][j] = dp[i][j-2]
 *      2->如果匹配的话至少匹配一个  -> s的前i-1个字符是可以被p串前j个所匹配的  dp[i][j] = dp[i-1][j]
 */
public class L0010MatchPattern {
    public boolean isMatch(String s, String p){
        if(s == null || p == null){
            return false;
        }
        int strLen = s.length();
        char[] str = s.toCharArray();
        int patLen = p.length();
        char[] pat = p.toCharArray();
        boolean[][] dp = new boolean[strLen+1][patLen+1];
        //初始值---两个空串是可以匹配的
        dp[0][0] = true;
        //当字符串为空时，只有前一个数字为* 并且dp[0][j-2]为真时，dp[0][j]才为true
        //注意第i个字符的位置应该是 **i-1**
        for (int j = 1; j <= patLen; j++) {
            if (pat[j-1] == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for(int i = 1; i <= strLen; i ++){
            for(int j = 1; j <= patLen; j ++){
                if(pat[j-1] == str[i-1] || pat[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pat[j-1] == '*'){
                    if(j >= 2){
                        if(pat[j-2] == str[i-1] || pat[j-2] == '.'){
                            dp[i][j] = dp[i][j-2] || dp[i-1][j];
                        }
                        //不等于的情况--->此时无法匹配
                        dp[i][j] |= dp[i][j-2];
                    }
                }
            }
        }
        return dp[strLen][patLen];
    }
}
