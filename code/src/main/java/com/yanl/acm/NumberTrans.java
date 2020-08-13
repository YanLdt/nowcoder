package com.yanl.acm;

/**
 * @author YanL
 * @date 21:35 2020/8/13
 * 给你一个正整数n，重复进行以下操作：
 * 1.如果n是奇数，令n=n-3
 * 2.如果n是偶数，令n=n/2
 * 重复上述直至n=0停止，请输出进行操作的次数，如果n永远无法变成零，输出-1
 */
public class NumberTrans {
    public int numberOfOperations(long n){
        if(n == 0){
            return 0;
        }
        int count = 0;
        while (n != 0){
            if(n % 2 == 1){
                n -= 3;
            }else {
                n /= 2;
            }
            if(n < 0){
                return -1;
            }
            count++;
        }
        return count;
    }
}
