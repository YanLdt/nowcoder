package com.yanl.leetcode;

/**
 * @author YanL
 * @date 0:40 2020/8/21
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 * 考虑使用数学方法
 * 每次换一瓶酒得到一个瓶子，但是失去了exchange个瓶子
 * 因此每次操作都会减少exchange-1个瓶子
 * b - n(e-1)>=e 满足这个条件就可以一直喝
 * 因此只需要找到 b - n(e-1) < e 满足该条件的n即可
 *
 */
public class L1518WaterBottles {

    public static void main(String[] args) {
        System.out.println(new L1518WaterBottles().numberWaterBottles(15, 4));
    }

    public int numberWaterBottles(int numBottles, int numExchange){
        int res = numBottles;
        while (numBottles / numExchange >= 1){
            int tmp  = numBottles % numExchange;
            numBottles /= numExchange;
            res += numBottles;
            numBottles += tmp;
        }
        return res;
    }
}
