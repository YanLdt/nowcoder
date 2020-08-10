package com.yanl.offer;

/**
 * @author YanL
 * @date 17:43 2020/8/10
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 * 使用位运算
 * 0011 + 0010 3 + 2 = 5
 * 异或之后为 0001
 * 相与之后为 0010 ---左移一位做进位 -> 0100
 * 再异或为 0101 = 5
 * 如此循环直到没有进位
 */
public class Add {
    public int add(int num1,int num2) {
        int res = 0;
        int carry = 0;
        while (num2!= 0){
            //相加不管进位
            res = num1 ^ num2;
            //求进位
            carry = (num1 & num2) << 1;

            num1 = res;
            num2 = carry;
        }
        return num1;
    }
}
