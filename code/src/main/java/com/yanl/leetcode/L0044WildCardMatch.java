package com.yanl.leetcode;

/**
 * @author YanL
 * @date 10:23 2020/8/25
 * 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * dp[i][j]表示字符串的前i个字符可以被通配符的前j个字符匹配到
 * 依旧分三种情况：
 *  p[j-1]为字符 如果p[i-1] == s[i-1]  dp[i][j] = dp[i-1][j-1]
 *  p[j-1]为'?'  dp[i][j] = dp[i-1][j-1]
 *  p[j-1]为'*'
 *  -->不使用这个'*' 则dp[i][j] = dp[i][j-1]
 *  -->使用这个'*' 则dp[i][j] = dp[i-1][j]
 *  dp[0][0] = true
 *  dp[i][0] = false
 *  dp[0][j] 只有全为'*'才匹配成功
 *  dp[i][j]需要计算
 */
public class L0044WildCardMatch {
    public boolean isMatch(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        //字符串为空的情况下
        for(int i = 1; i <= pLen; i++){
            if(pChar[i-1] == '*'){
                dp[0][i] = true;
            }else{
                //如果存在非*字符则无法匹配成功
                break;
            }
        }
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= pLen; j++){
                if(pChar[j-1] == sChar[i-1] || pChar[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    if(pChar[j-1] == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }
}
