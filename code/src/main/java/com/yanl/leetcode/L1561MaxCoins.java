package com.yanl.leetcode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 10:44 2020/8/24
 * 有3n堆数目不一的硬币，分硬币
 * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 * Alice 将会取走硬币数量最多的那一堆。
 * 你将会取走硬币数量第二多的那一堆。
 * Bob 将会取走最后一堆。
 * 重复这个过程，直到没有更多硬币。
 * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
 * 返回你可以获得的最大硬币数目。
 */
public class L1561MaxCoins {
    public static void main(String[] args) {
        int[] piles = new int[]{9,8,7,6,5,1,2,3,4};
        System.out.println(new L1561MaxCoins().maxCoins(piles));
    }
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int number = len / 3;
        int res = 0;
        int i = len -2;
        while (number > 0){
            res += piles[i];
            number--;
            i-=2;
        }
        return res;
    }
}
