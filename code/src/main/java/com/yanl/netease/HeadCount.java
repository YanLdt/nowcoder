package com.yanl.netease;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author YanL
 * @date 14:28 2020/8/8
 * 统计数组中相同数字有多少个
 */
public class HeadCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int out = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> res = headCount(arr);
        for(int i = 0; i < out; i++){
            int key = sc.nextInt();
            if(res.containsKey(key)){
                System.out.println(res.get(key));
            }else{
                System.out.println(0);
            }
        }

    }

    public static HashMap<Integer, Integer> headCount(int[] arr){
        HashMap<Integer, Integer> res = new HashMap<>();
        for(int a : arr){
            res.put(a, res.getOrDefault(a, 0) + 1);
        }
        return res;
    }
}
