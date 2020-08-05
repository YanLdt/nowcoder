package com.yanl.pdd2021;

import java.util.Scanner;

/**
 * @Author: YanL
 * @Time: 19:01 2020/8/2
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 真正的夏天，从清晨7点就开始空气就变得燥热，窗外蝉在叫。
 * 多多躺在床上，直勾勾地望着有些陌生的天花板，回忆着刚才的噩梦。
 * 在梦里，多多一个人在玩飞行棋，还剩一个棋子没到终点，距离终点还有 K 个格子。
 * 之后多多投了 N 次骰子，多多清楚地记得每次投出的骰子点数是多少。
 * 但第 N 次骰子投出之后多多就从梦中醒来，不记得最终自己棋子是否到达终点。
 * 现在多多一直在回想最终自己到达终点没……
 *
 * 输入描述:
 * 输入共2行。
 * 第一行是2个整数 K，N，分别表示棋子最终到终点的距离以及之后投掷的骰子次数。其中 0 <= K <= 600, 1 <= N <= 100。
 * 第二行包含 N 个整数，其中第 i (1 <= i <= N) 个整数 Di (1 <= Di <= 6) 表示第 i 次投出的骰子点数。
 * 输出描述:
 * 输出共1行，请注意行首、行尾不要输出多余的空格。
 * 若在第 N 次骰子之前就已经到达终点，则输出字符串 "paradox"。
 * 否则输出2个整数：最终棋子的位置（到终点的距离），以及共回退了多少次。2个整数之间以单个空格隔开。
 *
 * 输入
 * 10 2
 * 6 3
 * 输出
 * 1 0
 * 说明
 * 2次共前进6+3=9格
 * 示例2输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 10 4
 * 6 3 3 3
 * 输出
 * 1 2
 * 说明
 * 第3次和第4次投骰子，棋子都没能恰好落在终点，共回退2次
 * 示例3输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 6 3
 * 4 2 6
 * 输出
 * paradox
 */
public class FlyChess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(result(arr, n, k));
    }
    private static String result(int[] arr, int n, int k){
        int res = 0;
        StringBuilder ans = new StringBuilder();
        int back = 0;
        for(int a : arr){
            res += a;
            if(res == k){
                ans.append("paradox");
                return ans.toString();
            }
            if(res > k){
                res = 2*k-res;
                back += 1;
            }

        }
        ans.append(k - res).append(" ").append(back);
        return ans.toString();
    }
}
