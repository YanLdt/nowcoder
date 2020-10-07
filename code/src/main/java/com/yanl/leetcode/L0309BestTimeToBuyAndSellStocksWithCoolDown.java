package com.yanl.leetcode;

/**
 * @author YanL
 * @date 15:01 2020/10/7
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 处于冷冻期表示第i天结束后的状态，也就是说：如果第 i 天结束之后处于冷冻期，
 * 那么第 i+1 天无法买入股票。
 * f[i]表示第i天结束后的收益
 * f[i][0] 表示 第i天结束后持有一份股票
 * f[i][1] 表示 第i天结束后没有持有股票，并且处于冷冻期
 * f[i][2] 表示 第i天结束后没有持有股票，并且不属于冷冻期
 * f[i][0] = max(f[i-1][0](当天没有购买股票), f[i-1][2] - prices[i](当天买入一只股票
 *           所以前一天不能持有股票并且**第i-1天结束后**不能处于冷却期))
 * f[i][1] = f[i-1][0] + prices[i]，当天卖出一只股票
 * f[i][2] = max(f[i-1][1], f[i-1][2] 当天不做任何操作，i-1天两种状态  冷冻期-非冷冻期
 *
 */
public class L0309BestTimeToBuyAndSellStocksWithCoolDown {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < len; i ++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
