package com.yanl.leetcode;

import java.util.List;

/**
 * @author YanL
 * @date 10:43 2020/9/4
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 动态规划
 * dp[i]表示前i-1个字符能否被拆分为单词
 * dp[i] = dp[j] && list.contains(s.subString(j+1,i))
 *
 */
public class L0139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null){
            return false;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[] dp = new boolean[len+1];
        //不要忘记初始化
        dp[0] = true;
        for(int i = 1; i <= len; i ++){
            //这边可以进行优化
            for(int j = 0; j < i; j ++){
                if(dp[j] && wordDict.contains(s.substring(j+1, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
