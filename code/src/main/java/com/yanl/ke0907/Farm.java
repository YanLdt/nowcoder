package com.yanl.ke0907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author YanL
 * @date 15:40 2020/9/7
 */
public class Farm {

    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                List<Integer> tmp = new ArrayList<>();
                for (int l = 0; l < k; l++) {
                    tmp.add(sc.nextInt());
                }
                list.add(new ArrayList<>(tmp));
            }
            backTrack(n, list, 1, m, 1);
            System.out.println(res);
        }
    }

    public static void backTrack(int n, List<List<Integer>> list, int index, int m, int count) {
        if (count == n) {
            res = res + 1 % 1000000007;
            return;
        }
        if (index > m) {
            return;
        }
        for (int i = 1; i <= m; i++) {
            if(i > 1){
                List<Integer> pre = list.get(index - 1);
                if (pre.contains(i)) {
                    continue;
                }
            }
            count++;
            //System.out.println(count+"回溯前");
            backTrack(n, list, index + 1, m, count);
            //System.out.println(count + "回溯后");
            count--;
        }
    }
}
