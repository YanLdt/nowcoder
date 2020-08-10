package com.yanl.offer;

/**
 * @author YanL
 * @date 21:13 2020/8/10
 * 把字符串转换成整数
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public int strToInt(String str){
        //首先判断是否为空
        if("".equals(str) || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int start, res = 0;
        boolean flag = true;
        //然后判断标志位
        if(chars[0] == '+'){
            start = 1;
        }else if(chars[0] == '-'){
            start = 1;
            flag = false;
        }else{
            start = 0;
            flag = true;
        }
        //判断是否合法
        for(int i = start; i < len; i++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                res = res * 10 + chars[i] - '0';
            }
            else{
                return 0;
            }
        }
        //根据标志不同返回结果也不同
        if(flag){
            return res;
        }else {
            return (-1)* res;
        }
    }
}
