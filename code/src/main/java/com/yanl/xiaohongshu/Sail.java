package com.yanl.xiaohongshu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author YanL
 * @date 19:39 2020/9/6
 * 航海士们在获得海贼王的宝藏后，起帆回家。为了能尽快回到家中，
 * 每天白天他们必须航行至少L海里，但船的速度又只能最多支持他们航行T海里，
 * 晚上大家会停船休息。夜晚的大海是充满危险的，在航线上大家知道有一些危险区域的存在，
 * 它们分别距离起点Ai海里，大家希望晚上尽量不在这些区域休息。
 *
 * 为了简化问题，我们假设航线是一条直线，船每天航行的距离是整数海里。
 * 现在，请帮大家规划一个航行方案，使得到达终点前在危险区域休息的次数最少。
 * X（距离终点的距离）
 *
 * L T N (3 个整数，每天最小航行距离L， 最大航行距离T，危险区域数N)
 *
 * A1 A2 ... AN (N个整数，每个危险区域距离起点的距离)
 *
 * 1个整数(最佳方案下在危险区域休息的次数)
10
2 3 4
5 3 2 6

 1
样例说明
第一天航行2公里，在危险区域休息
第二天航行2公里，在安全区域休息
第三天航行3公里，在安全区域休息
第四天航行3公里到达终点

数据说明
对于50%的数据，X < 10,000
对于100%的数据，X < 1,000,000,000
对于100%的数据，L<=T<=10, N<=100
 */
public class Sail {

    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        int danger = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < danger; i ++){
            set.add(sc.nextInt());
        }
        int len = max - min + 1;
        int [] arr = new int[len];
        int start = min;
        for(int i = 0; i < len; i ++){
            arr[i] = start++;
        }
        backTrack(arr, 0, 0, x, set);
        System.out.println(res);
    }
    public static void backTrack(int[] arr, int sum, int count, int x, Set<Integer> set){
        if(sum > x){
            return;
        }
        if(sum == x){
            res = Math.min(res, count);
            return;
        }
        for (int value : arr) {
            sum += value;
            if(sum > x){
                return;
            }
            if (set.contains(sum)) {
                count++;
            }
            backTrack(arr, sum, count, x, set);
            sum -= value;
        }
    }
}
