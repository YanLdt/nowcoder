package com.yanl.bilibili;

import java.util.Scanner;

/**
 * @author YanL
 * @date 10:19 2020/8/13
 * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
 *
 * 你总共三种操作方法：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * dp[i][j]表示word1前i个子串转换为word2前j个子串所需要的最少操作数
 * dp[i-1][j]+1 --- 插入字符
 * dp[i][j-1]+1 --- 删除字符等价于在word2中擦入字符
 * dp[i][j]+1 ---替换字符
 *
 * 初始化
 * dp[0][j] = j;
 * dp[i][0] = i;
 * dp[0][0] = 0;
 *
 */
public class LeastOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        //初始化
        dp[0][0] = 0;
        //第一行
        for(int i = 1; i <= len2; i++){
            dp[0][i] = i;
        }
        //第一列
        for(int i = 1; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                int insert = dp[i-1][j] + 1;
                int delete = dp[i][j-1] + 1;
                int update = dp[i-1][j-1];
                if(s1.charAt(i-1) != s2.charAt(j-1)){
                    update+=1;
                }
                dp[i][j] = Math.min(insert, Math.min(delete, update));
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
