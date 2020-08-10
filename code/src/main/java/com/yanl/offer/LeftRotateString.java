package com.yanl.offer;

/**
 * @author YanL
 * @date 14:27 2020/8/10
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”
 */
public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        System.out.println(leftRotateString(str, n));
    }
    public static String leftRotateString(String str,int n) {
        if(str == null ||str.length() == 0){
            return "";
        }
        String sub = str.substring(0, n);
        return str.substring(n).concat(sub);
    }
}
