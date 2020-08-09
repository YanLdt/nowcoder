package com.yanl.offer;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 数组中整数1出现的次数
 */
public class NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(count(13));
    }

    public static int count(int n){
        int res = 0;
        //注意是闭区间
        for(int i = 1; i <= n; i++){
            res += numberOf1(i);
        }
        return res;
    }

    /**
     * 计算当前元素包含的1的个数
     * @param n
     * @return
     */
    public static int numberOf1(int n){
        int num = 0;
        //不断计算n/10的个位数字是否为1
        while (n != 0){
            if((n % 10) == 1){
                num += 1;
            }
            n /= 10;
        }
        return num;
    }
}
