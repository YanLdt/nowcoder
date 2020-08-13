package com.yanl.acm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YanL
 * @date 21:39 2020/8/13
 * 牛牛最近迷上了小游戏，于是他也想对他的01字符串进行一些操作，
 * 01字符串上的0和0相邻时会变成1，而1和1相邻时会在字符串上消失，
 * 而0和1相邻时什么都不会发生，牛牛现在把初始的字符串给你，
 * 你能告诉牛牛这个字符串最后会变成什么样吗。
 */
public class ZeroOneGame {

    public static void main(String[] args) {
        String str = "00110001";
        System.out.println(new ZeroOneGame().solve(str));
    }
    public String solve(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        if(str.length() == 1){
            return str;
        }
        char[] chars = str.toCharArray();
        int len = str.length();
        int i = 0;
        int j = 1;
        char pre;

        return null;
    }
}
