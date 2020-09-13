package com.yanl.leetcode;

import java.util.Arrays;

/**
 * @author YanL
 * @date 10:59 2020/9/13
 * 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，
 * 从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * dp[i][j]表示楼层数为i时，鸡蛋为j所需要的最小次数
 * k为当前所在的楼层 k <= i
 * 1-没碎  dp[i-k][j]
 * 2-碎    dp[k-1][j-1]
 * 两种情况最大值的最小值才是结果
 * N+1行 K+1列
 * 初始化：
 * N=0，楼层为0,测不出 0
 * N=1 楼层为1，只需要扔一次 1
 * K=0 鸡蛋为0 不可能  0
 * K=1 等于楼层高度 N
 */
public class L0887EggFall {
    public int superEggDrop(int K, int N){
        int[][] dp = new int[N+1][K+1];
        //初始化一个较大的数  因为要求最小值
        for(int i = 0; i <= N; i ++){
            Arrays.fill(dp[i], i);
        }
        //楼层为0
        for(int j = 0; j <= K; j ++){
            dp[0][j] = 0;
        }
        dp[1][0] = 0;
        for(int j = 1; j <= K; j ++){
            dp[1][j] = 1;
        }
        for(int i = 0; i <= N; i ++){
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for(int i = 2; i <= N; i ++){
            for(int j = 2; j <= K; j ++){
                int left = 1;
                int right = i;
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    //递增
                    int breakEgg = dp[mid-1][j-1];
                    //递减
                    int notBreak = dp[i-mid][j];
                    if(breakEgg > notBreak){
                        right = mid - 1;
                    }else if(breakEgg < notBreak){
                        left = mid + 1;
                    }else {
                        left = mid;
                        break;
                    }
                }
                dp[i][j] = Math.max(dp[left-1][j-1], dp[i-left][j]) + 1;
            }
        }

        return dp[N][K];
    }
}
