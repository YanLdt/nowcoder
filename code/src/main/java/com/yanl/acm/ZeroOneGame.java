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
 * ac暴力就完事了
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
        StringBuilder sb = new StringBuilder();
        int len = chars.length;
        sb.append(chars[0]);
        //pos指向结果集的最后一个字符
        int pos = 0;
        for(int i = 1; i < len; i++){
            char curC = chars[i];
            //当结果的倒数第一个字符与当前的字符相等
            if(pos >= 0 && sb.charAt(pos) == curC){
                //第一种情况  两者都为1
                if(curC == '1'){
                    //删去结果集的倒数最后一个字符
                    sb.deleteCharAt(pos);
                    pos--;
                }else{
                    //两者都为0,相遇变为1之后需要判断前一位的值
                    sb.deleteCharAt(pos);
                    sb.append('1');
                    //判断当前1的前一位是否为1
                    if(pos > 0 && sb.charAt(pos-1) == '1'){
                        //左闭右开
                        sb.delete(pos-1, pos+1);
                        //这个时候删去了两个1
                        pos-=2;
                    }
                }
            }else{
                sb.append(curC);
                pos++;
            }
        }
        return sb.toString();
    }
}
