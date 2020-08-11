package com.yanl.offer;

/**
 * @author YanL
 * @date 13:49 2020/8/11
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 点之前不能出现点和e/E，且只能出现一次
 * E之前必须是数字，而且前面不能再有E，
 * +-号必须在开头或者E/e之后
 * 就一个一个判断条件
 *
 */
public class StringIsNumeric {
    public boolean isNumeric(char[] str) {
        int len = str.length;
        if(len == 0){
            return false;
        }
        boolean point = false;
        boolean number = false;
        boolean eTag = false;
        for(int i = 0; i < len; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                number = true;
            }else if(str[i] == '.'){
                if(point || eTag){
                    return false;
                }
                point = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(eTag || !number){
                    return false;
                }
                eTag = true;
                //这里需要把数字为置位false  E 后必须要有数字，再加一个判断
                number = false;
            }else if(str[i] == '+' || str[i] == '-'){
                if(i != 0 && str[i - 1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return number;
    }
}
