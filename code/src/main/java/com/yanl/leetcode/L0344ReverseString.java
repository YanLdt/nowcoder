package com.yanl.leetcode;

/**
 * @author YanL
 * @date 21:33 2020/10/13
 */
public class L0344ReverseString {
    public void reverseString(char[] s){
        int len = s.length;
        int left = 0;
        int right = len - 1;
        for( ; left <= right; left ++, right --){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
