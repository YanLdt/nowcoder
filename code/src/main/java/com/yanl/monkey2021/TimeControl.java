package com.yanl.monkey2021;

import java.util.*;

/**
 * @Author: YanL
 * @Time: 19:40 2020/8/1
 * @Email: imyanl.dt@gmail.com
 * @Description:
 *
 * 4
 * 1 4
 * 1 2
 * 2 3
 * 3 4
 *
 * 2
 *
 * 0.3
 */
public class TimeControl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i< n; i++){
            int[] tmp = new int[2];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            list.add(tmp);
        }
        System.out.println(minHeart(list, n));
    }

    private static int minHeart(List<int[]> list, int n){
        int left, right;
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        System.out.println(list.toString());
        left = list.get(0)[0];
        right = list.get(0)[1];

        for(int[] a: list){
            System.out.println(Arrays.toString(a));
            if(a[0] <= left){
                left = a[0];
            }
            if(a[1] > right){
                right = a[1];
            }
        }
        int[] res = new int[right - left+1];
        for(int i = left; i < right; i++){
            int count = 0;
            for(int[] a : list){
                if(i >= a[0] && i < a[1]){
                    count++;
                }

            }
            res[i-left] = count;
        }

        int ans = res[0];
        for(int r : res){
            if(ans <= r){
                ans = r;
            }
        }
        return ans;
    }
}
