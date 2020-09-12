package com.yanl.ThreeSixZero;

import java.util.*;

/**
 * @author YanL
 * @date 21:01 2020/9/11
 *
 */
public class Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map0 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = new int[]{a, b};
            set.add(a);
        }
        int left = -1;
        int right = -1;
        if(arr[0][1] == 1){
            left = arr[0][0];
        }
        if(arr[m-1][1] == 0){
            right = arr[m-1][0];
        }
        if(left == right || right == -1){
            set.remove(left);
        }else if(left == -1){
            set.remove(right);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++){
            if(!set.contains(i)){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
