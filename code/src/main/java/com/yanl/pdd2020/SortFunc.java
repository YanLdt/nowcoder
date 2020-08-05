package com.yanl.pdd2020;

import java.util.Scanner;

/**
 * @Author: YanL
 * @Time: 16:08 2020/8/2
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 数列 {An} 为N的一种排列。
 * 例如N=3，可能的排列共6种：
 * 1, 2, 3
 * 1, 3, 2
 * 2, 1, 3
 * 2, 3, 1
 * 3, 1, 2
 * 3, 2, 1
 * 定义函数F:
 *
 * 其中|X|表示X的绝对值。
 *
 * 现在多多鸡想知道，在所有可能的数列 {An} 中，F(N)的最小值和最大值分别是多少。
 *
 * 输入描述:
 * 第一行输入1个整数T，表示测试用例的组数。
 * ( 1 <= T <= 10 )
 * 第二行开始，共T行，每行包含1个整数N，表示数列 {An} 的元素个数。
 * ( 1 <= N <= 100,000 )
 *
 * 输出描述:
 * 共T行，每行2个整数，分别表示F(N)最小值和最大值
 *
 * 输入例子1:
 * 2
 * 2
 * 3
 *
 * 输出例子1:
 * 1 1
 * 0 2
 *
 * 例子说明1:
 * 对于N=3：
 * - 当{An}为3，2，1时可以得到F(N)的最小值0
 * - 当{An}为2，1，3时可以得到F(N)的最大值2
 */
public class SortFunc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            System.out.println(min(a) + " " + max(a));
        }
    }

    /**
     * 可以发现四个为一组   1 最小值为1 2最小值为1 3最小值为0， 4最小值为0
     * @param n 数字个数
     * @return 返回最小值
     */
    private static int min(int n){
        if(n % 4 == 0 || n % 4 == 3){
            return 0;
        }
        else {
            return 1;
        }
    }

    private static int max(int n){
        return n - min(n-1);
    }
}
