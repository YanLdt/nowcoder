package com.yanl.ali0812;

/**
 * @author YanL
 * @date 10:56 2020/8/14
 * 给一个数字N，找一个数M小于等于N,使得M的二进制位数和N的二进制位数一样
 * 且M的二进制所包含的1的个数最多，如果存在多个符合条件的M,输出最小的M
 * 2
 * 12
 * 48
 *
 */
public class MinM {
    public static void main(String[] args) {
        int n = 13;
        String b = Integer.toBinaryString(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.parseInt(b, 2));
    }
}
