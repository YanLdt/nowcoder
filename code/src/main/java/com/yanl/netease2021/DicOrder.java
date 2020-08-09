package com.yanl.netease2021;

import java.util.*;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 给定长度为 m 的序列 T ,求一个长度为 n 且字典序最小的排列.并且要求序列 T 为所求排列的子序列.题目保证这样的排列一定存在.
 * S 是 T 的子序列,当且仅当 S 是 T 通过删除任意数量元素所得到的.
 * 字典序是单词在字典中的排列顺序，先比较第一个字母，然后比较第二个字母，依次类推。
 * 5 3
 * 2 1 5
 * 2 1 3 4 5
 *
 * 5 2
 * 4 2
 * 1 3 4 2 5
 *
 */
public class DicOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        dicOrder(n, m, arr);
    }

    public static void dicOrder(int n, int m, int[] arr){
        int[] res = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        for(int i = 0; i < m; i++){
            vis[arr[i]] = true;
            queue.offer(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(vis[i]){
                continue;
            }
            while (!queue.isEmpty() && queue.peek() < i){
                sb.append(queue.poll()).append(" ");
            }
            sb.append(i).append(" ");
        }
        //最大值在最后需要取出
        while (!queue.isEmpty()){
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
/*
5 2
4 2
1 3 4 2 5
*/
