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
}
