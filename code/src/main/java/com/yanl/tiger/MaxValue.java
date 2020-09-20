package com.yanl.tiger;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author YanL
 * @date 17:24 2020/9/20
 * 最大收益
 */
public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //项目总量
        int n = sc.nextInt();
        //初始资金
        int w = sc.nextInt();
        //最多可以做的项目数量
        int k = sc.nextInt();
        int[] costs = new int[n];
        for(int i = 0; i < n; i ++){
            costs[i] = sc.nextInt();
        }
        int[] profits = new int[n];
        for(int i = 0; i < n; i ++){
            profits[i] = sc.nextInt();
        }
        sc.close();

        //做一个大顶堆 利润
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        //小顶堆  资金
        PriorityQueue<Integer> minCosts = new PriorityQueue<>(Comparator.comparingInt(a -> costs[a]));

        for(int i = 0; i < n; i ++){
            if(costs[i] > w){
                minCosts.add(i);
            }else {
                maxProfits.add(i);
            }
        }
        while (k > 0 && !maxProfits.isEmpty()){
            while (!minCosts.isEmpty() && costs[minCosts.peek()] <= w){
                maxProfits.offer(minCosts.poll());
            }
            w += profits[maxProfits.poll()];
            k--;
        }
        System.out.println(w);
    }
}
