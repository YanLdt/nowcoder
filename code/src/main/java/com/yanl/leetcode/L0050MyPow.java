package com.yanl.leetcode;

/**
 * @author YanL
 * @date 16:14 2020/10/14
 * Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class L0050MyPow {
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? fastPow(x, N) : 1.0 / fastPow(x, -N);
    }

    /**
     * 快速幂  使用位运算
     * @param x 基础值
     * @param n 幂指数
     * @return 返回结果
     */
    public static double fastPow(double x, long n){
        if(n == 0){
            return 1;
        }
        double res = 1.0;
        double base = x;
        while (n > 0){
            long tmp = n & 1;
            //如果当前位为1 则乘上基础值
            if(tmp == 1){
                res *= base;
            }
            //每次右移都要更新基础值
            base *= base;
            n >>= 1;
        }
        return res;
    }
}
