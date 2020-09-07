package com.yanl.ke0907;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author YanL
 * @date 15:24 2020/9/7
 * 石头剪刀布
 *
 */
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i ++){
            Map<Character, Integer> map = new HashMap<>();
            map.put('S', 0);
            map.put('J', 0);
            map.put('B', 0);
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            char[] arr = new char[4];
            for(int j = 0; j < 4; j ++){
                arr[j] = s1[j].charAt(0);
                if(j > 1){
                    map.put(arr[j], map.get(arr[j]) + 1);
                }
            }
            System.out.println(Arrays.toString(arr));
            int[] a = new int[2];
            for(int j = 0; j < 2; j ++){
                if(arr[j] == 'S'){
                    a[j] = map.get('J');
                }else if(arr[j] == 'J'){
                    a[j] = map.get('B');
                }else {
                    a[j] = map.get('S');
                }
            }
            if(a[0] > a[1]){
                System.out.println("left");
            }else if(a[0] < a[1]){
                System.out.println("right");
            }else {
                System.out.println("same");
            }
        }
    }
}
