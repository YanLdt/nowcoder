package com.yanl.sf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author YanL
 * @date 20:49 2020/8/20
 * 克里森是一名赏金猎人，他平时需要完成一些任务赚钱。最近他收到了一批任务，但是受到时间的限制，
 * 他只能完成其中一部分。具体来说就是有n个任务，每个任务用l, r, w来表示任务开始的时间l，
 * 结束的时间r和完成任务获得的金钱。
 *
 * 克里森是个贪心的人，他想知道自己在任务不冲突的情况下最多获得多少金钱。
 *
 * 第一行一个数n表示任务的个数。(1≤n≤1e3)
 *
 * 接下来n行每行三个整数l, r, w表示第i个任务的开始时间，结束时间，以及收益。(1≤l≤r≤1e6,1≤w≤1e9)
 *
 * 输出一个值表示克里森最多获得的金钱数量。
 *
 * 3
 * 1 3 5
 * 2 7 3
 * 5 10 1
 *
 * 6
 */
public class Hunter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> mission = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] tmp = new int[3];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            tmp[2] = sc.nextInt();
            mission.add(tmp);
        }
        mission.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                        return o2[2] - o1[2];
                }
                return o1[0] - o2[0];
            }
        });
        long res = mission.get(0)[2];
        for(int i = 1, j = 0; i < n; i++){
            if(mission.get(i)[0] >= mission.get(j)[1]){
                res+=mission.get(i)[2];
                j++;
            }
        }
        System.out.println(res);
    }
}
