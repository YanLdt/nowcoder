package com.yanl.offer;

/**
 * @author YanL
 * @date 22:44 2020/8/10
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 */
public class MatchPattern {

    public static void main(String[] args) {
        MatchPattern matchPattern = new MatchPattern();
        System.out.println(matchPattern.match("".toCharArray(), ".*".toCharArray()));

    }

    public boolean match(char[] str, char[] pattern) {
        int strLen = str.length;
        int parLen = pattern.length;
        if (strLen != 0 && parLen == 0) {
            return false;
        }
        boolean[][] dp = new boolean[strLen + 1][parLen + 1];
        dp[0][0] = true;
        //当字符串为空时，只有前一个数字为* 并且dp[0][j-2]为真时，dp[0][j]才为true
        for (int j = 1; j <= parLen; j++) {
            if (pattern[j - 1] == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= strLen; i++) {
            for (int j = 1; j <= parLen; j++) {
                char a = str[i - 1], b = pattern[j - 1];
                if (a == b || b == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (b == '*') {
                    //这是p[j]='*'的情况 --- 下面两种情况任意一种情况匹配都是成功的，
                    if (j >= 2) {
                        char c = pattern[j - 2];
                        if (a == c || c == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                        }
                        // 'x*'不匹配任何字符，但是前面已经匹配成功了
                        dp[i][j] = dp[i][j] || dp[i][j - 2];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[strLen][parLen];
    }


    /**
     * 动态规划
     * 正则的前一个字符有三种情况，正常字符、'.'、'*'
     * 当为正常字符时，只需判断字符串的前一个字符与正则的前一个字符是否相同
     * 当位'.'时，因为'.'可以匹配任意字符，所以也只需字符串的前一个字符与正则的前一个字符是否相同
     * 当为'*'时，有两种情况'x*'----不匹配，直接忽略'x*'因此只需比较字符串的前一个字符与正则去掉后两个字符
     * ------------------------匹配一个或多个的话，此时必须是s[i-1] = x 或者c = '.'如果匹配成功，字符串继续左移
     *
     * 初始值：
     * S为空，P为空 dp[0][0] = true---肯定匹配成功
     * S为空，P不为空：需要计算
     * S不为空，P为空dp[i][0] = false ---肯定匹配不成功
     * S不为空，P不为空：需要计算
     * @param str
     * @param pattern
     * @return
     */
    public boolean matchV2(char[] str, char[] pattern) {
            int strLen = str.length;
            int patLen = pattern.length;
            boolean[][] dp = new boolean[strLen+1][patLen+1];
            for(int i = 0; i <= strLen; i++){
                for(int j = 0; j <= patLen; j++){
                    //分两种情况讨论--空正则和非空正则
                    //空正则
                    if(j == 0){
                        dp[i][j] = i == 0;
                    }else{
                        //非空正则
                        //非'*'
                        if(pattern[j-1] != '*'){
                            //如果字符串的前一个字符与正则的前一个字符相等或者正则的前一个字符为'.'
                            if(i > 0 && (str[i-1] == pattern[j-1] || pattern[j-1] == '.')) {
                                dp[i][j] = dp[i-1][j-1];
                            }
                        }else{
                            //'*'--以下两种情况任意满足一种即可匹配成功因此为|=
                            //这个是不匹配，直接跳过'x*'
                            if(j >= 2){
                                dp[i][j] |= dp[i][j-2];
                            }
                            //这种情况是匹配一个或者多个
                            if(i >= 1 && j >= 2 && (str[i-1] == pattern[j-2] || pattern[j-2] == '.')){
                                dp[i][j] |= dp[i-1][j];
                            }
                        }
                    }
                }
            }
            return dp[strLen][patLen];
    }


    /*
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        int strIndex = 0;
        int patIndex = 0;
        return matchFunc(str, strIndex, pattern, patIndex);
    }
    public boolean matchFunc(char[] str, int strIndex, char[] pattern, int patIndex){
        //首先判断是否已经匹配成功
        //字符串和匹配字符串都已遍历完毕
        if(strIndex == str.length && patIndex == pattern.length){
            return true;
        }
        //字符串已经遍历完，但是正则表达式还没有走完
        if(strIndex != str.length && patIndex == pattern.length){
            return false;
        }
        //如果正则表达式的下一个字符为'*'
        if(patIndex + 1 < patIndex && pattern[patIndex + 1] == '*'){
            //如果字符相等或者正则表达式为'.'，即如果能够匹配上的话可以有三种状态选择
            if((strIndex != str.length && pattern[patIndex] == str[strIndex]) || (pattern[patIndex] == '.' && strIndex != str.length)){
                return matchFunc(str, strIndex, pattern, patIndex+2) //正则表达式后移两位，视为x*匹配0个字符
                        || matchFunc(str, strIndex+1, pattern, patIndex+2) //此时表示匹配一个字符
                        || matchFunc(str, strIndex+1, pattern, patIndex); //表示匹配多个字符，继续判断字符串的下一个字符
            }else{
                //不匹配的话
                return matchFunc(str, strIndex, pattern, patIndex+2);
            }
        }
        if((strIndex != str.length && pattern[patIndex] == str[strIndex]) || (pattern[patIndex] == '.' && strIndex != str.length)){
            return matchFunc(str, strIndex + 1, pattern, patIndex + 1);
        }
        return false;
    }
    */
}
