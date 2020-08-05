package com.yanl.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: YanL
 * @Time: 22:32 2020/8/5
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class PermutationOfString {

    public static void main(String[] args) {
        PermutationOfString p = new PermutationOfString();
        System.out.println(p.permutation("abc").toString());
    }

    public ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str != null && str.length() > 0){
            permutationFunc(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;

    }

    /**
     * 递归方法
     *
     * @param chars
     * @param i
     * @param list
     */
    public void permutationFunc(char[] chars, int i, ArrayList<String> list){
        if(i == chars.length - 1){
            String s = String.valueOf(chars);
            if(!list.contains(s)){
                list.add(s);
            }
        }else{
            //遍历所有可能出现在第一个位置的字符
            for(int j = i; j < chars.length; j++){
                //这一步交换首位固定字符之后的字符
                swap(chars, i, j);
                permutationFunc(chars, i+1, list);
                //这里回溯，递归之前做了什么，递归之后就要撤销
                swap(chars, i, j);
            }
        }
    }

    /**
     * 交换函数
     * @param chars
     * @param i
     * @param j
     */
    public void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
