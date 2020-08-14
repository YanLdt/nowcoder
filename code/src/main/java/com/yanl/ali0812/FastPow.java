package com.yanl.ali0812;

/**
 * @author YanL
 * @date 15:32 2020/8/14
 * 快速幂算法
 * 利用位运算
 * 3^3 = 3^(0011) = 3 ^ (2^1 + 2^0) = 3*(2^1) * 3*(2^0);
 */
public class FastPow {
    public static void main(String[] args) {
        System.out.println(new FastPow().fastPow(5, 3));
    }

    /**
     * 快速幂方法
     * @param a 基准值
     * @param b 幂指数
     * @return 返回结果
     */
    public int fastPow(int a, int b){
        int res = 1;
        int base = a;
        while (b > 0){
            int m = b & 1;
            if(m != 0){
                //如果当前位为1则乘到结果上
                res *= base;
            }
            //记录每一位对应的基准值
            base *= base;
            b >>= 1;
        }
        return res;
    }
}
