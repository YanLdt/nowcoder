package com.yanl.pdd2020;

import java.util.Scanner;

/**
 * @Author: YanL
 * @Time: 15:29 2020/8/2
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。
 * 多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
 * 通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
 * 那么请问聪明的你，是否已经知道了应该如何操作呢？
 * 输入描述:
 * 第一行，有1个整数T，表示测试用例的组数。
 * （1 <= T <= 100）
 * 接下来T行，每行1个整数N，表示有N个魔术盒子。
 * （1 <= N <= 1,000,000,000）
 *
 * 输出描述:
 * 共T行，每行1个整数，表示要将所有盒子的球变没，最少需要进行多少次操作。
 *
 * 输入例子1:
 * 3
 * 1
 * 2
 * 5
 *
 * 输出例子1:
 * 1
 * 2
 * 3
 *
 * 100%
 */
public class MagicBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println(empty(sc.nextInt(), n));
        }
    }
    private static int empty(int a, int n){
        int min = 0;
        while(a>1){
            a /= 2;
            min++;
        }
        return min+1;
    }
}
