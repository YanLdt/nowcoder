package com.yanl.leetcode;

/**
 * @author YanL
 * @date 17:58 2020/8/24
 * 最长有效括号的长度
 * 给一个只包含'(',')'的字符串，找出最长的包含有效括号的字串的长度
 * dp[i]表示以i结尾的字符串的最长有效字符串
 * 如果s[i] = '(' 则构不成有效字符串
 * 如果s[i] = ')'
 *      1-> s[i-1] = '(' dp[i] = dp[i-2]+2
 *      2-> s[i-1] = ')' 并且dp[i-dp[i-1]-1] = '(' 时
 *          dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-1-1]
 */
public class L0032LongestValidParentheses {
    public int longestValidParentheses(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len];
        int res = 0;
        dp[0] = 0;
        for(int i = 1; i < len; i++){
            if(chars[i] == '('){
                dp[i] = 0;
            }else {
                if(chars[i-1] == '('){
                    dp[i] = (i - 2 >= 0) ? dp[i-2] + 2 : 2;
                }else if(chars[i-1] == ')' && (i - dp[i-1] - 1) >= 0 && chars[i - dp[i-1] - 1] == '('){
                    dp[i] = dp[i-1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
