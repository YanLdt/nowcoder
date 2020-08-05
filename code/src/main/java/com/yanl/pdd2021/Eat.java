package com.yanl.pdd2021;

import java.util.*;

/**
 * @Author: YanL
 * @Time: 19:27 2020/8/2
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 多多公司每天给员工提供免费的三餐，而小多由于习惯性赖床，所以他从来吃不到早餐。
 * 今天公司提供了N套中餐和M套晚餐，每种套餐分别有一个热量值X和美味值Y。
 * 小多想知道，在满足美味值之和不少于T的情况下，最少可以摄入多少热量值？
 * 每顿饭最多只能选择一种套餐，小多可以选择只吃一顿饭甚至不吃饭。
 * 输入描述:
 * 第一行三个整数N，M，T，分别表示中餐种数，晚餐种数以及小多需要满足的最少美味值
 * 然后N行第i行两个整数Xi和Yi，表示第i套中餐的热量值和美味值
 * 最后M行第j行两个整数Xj和Yj，表示第j套晚餐的热量值和美味值
 * 输出描述:
 * 一个整数，表示小多在这两顿饭的美味值之和不少于T的前提下，最少摄入的热量值
 * 如果小多两顿饭的美味值之和无论如何都无法达到T，则输出-1
 *
 * 5 1 9
 * 9 1
 * 4 9
 * 3 1
 * 2 3
 * 6 5
 * 9 8
 *
 * 4
 * 只吃中午的第2种套餐，不吃晚餐
 * 1 1 0
 * 3 1
 * 2 1
 *
 * 0
 * 选择一顿都不吃
 * 3 3 10
 * 1 1
 * 2 5
 * 3 7
 * 2 4
 * 4 8
 * 6 9
 *
 * 5
 * 选择第3种中餐，和第1种晚餐
 * 2 1 4
 * 3 1
 * 2 1
 * 1 2
 *
 * -1
 * 无论怎么选，美味值都达不到4，所以输出-1
 * 对于50%的数据：1 <= N, M, Xi, Yi, Xj, Yj <= 1,000, 0 <= T <= 2,000
 * 对于100%的数据：1 <= N, M, Xi, Yi, Xj, Yj <= 100,000, 0 <= T <= 200,000
 */
public class Eat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int T = sc.nextInt();
        int[][] arr1 = new int[n][2];
        int[][] arr2 = new int[m][2];
        for(int i = 0; i < n; i++){
            arr1[i][0] = sc.nextInt();
            arr1[i][1] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            arr2[i][0] = sc.nextInt();
            arr2[i][1] = sc.nextInt();
        }
        System.out.println(minEnergy(arr1, arr2, T, n, m));
    }

    private static int minEnergy(int[][] arr1, int [][] arr2, int T, int n, int m){
        List<int[]> res = new ArrayList<>();
        //添加不选
        res.add(new int[]{0, 0});
        Arrays.sort(arr2);
        Arrays.sort(arr1);

        int count = 0;
        int ans = 0;
        //添加双选
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int[] tmp = new int[2];
                tmp[0] = arr1[i][0] + arr2[j][0];
                tmp[1] = arr1[i][1] + arr2[j][1];
                res.add(tmp);
                if(tmp[1] > T){
                    break;
                }
            }
        }
        //添加单选
        for(int i = 0; i < n; i++){
            res.add(arr1[i]);
        }
        for(int i = 0; i < m; i++){
            res.add(arr2[i]);
        }
        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        for(int[] a : res){
            if(a[1] >= T){
                ans = a[0];
                break;
            }else {
                ans = -1;
            }
        }
        return ans;
    }
}
