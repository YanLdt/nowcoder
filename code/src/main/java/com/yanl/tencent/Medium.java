package com.yanl.tencent;

import java.util.*;

/**
 * @author YanL
 * @date 21:13 2020/9/6
 * n个数，对于每个数字删除之后剩余的中位数
 * n为偶数
 */
public class Medium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
            list.add(arr[i]);
        }

        Collections.sort(list);
        int m1 = list.get(n / 2);
        int m2 = list.get(n / 2 - 1);
        for(int i = 0; i < n; i ++){
            int tmp = arr[i];
            int index = list.indexOf(tmp);
            if(index < n / 2){
                System.out.println(arr[n / 2]);
            }else {
                System.out.println(arr[n / 2 - 1]);
            }
        }
    }
}
