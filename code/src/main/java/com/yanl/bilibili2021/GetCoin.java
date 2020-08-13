package com.yanl.bilibili2021;

import java.util.ArrayList;

/**
 * @author YanL
 * @date 19:55 2020/8/13
 */
public class GetCoin {
    public int getCoin(int N) {
        if (N >= 1024) {
            return 0;
        }
        int[] coins = new int[4];
        coins[0] = 1;
        coins[1] = 4;
        coins[2] = 16;
        coins[3] = 64;
        int total = 1024 - N;
        int[] change = new int[total + 1];
        change[0] = 0;
        for (int i = 1; i <= total; i++) {
            for (int j = 0; j < 4; j++) {
                if (i >= coins[j]) {
                    change[i] = Math.min(change[i], change[i - coins[j] + 1]);
                }
            }
        }
        return change[total];
    }

}
