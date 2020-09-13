package com.yanl.iqiyi0913;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author YanL
 * @date 15:40 2020/9/13
 * 三数之和
 */
public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        sc.close();
        int[] arr = new int[s.length];
        for(int i = 0; i < s.length; i ++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < arr.length-1 && arr[i] <= 0; i ++){
            if( i > 0 && arr[i-1] == arr[i]){
                continue;
            }
            int a = -arr[i];
            int left = i+1;
            int right = arr.length - 1;
            while (left < right){
                if(arr[left] + arr[right] == a){
                    res.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left+1]){
                        left++;
                    }
                    while (left < right && arr[right] == arr[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(arr[left] + arr[right] > a){
                    right--;
                }else {
                    left++;
                }
            }
        }
        for(List<Integer> l : res){
            for(int a : l){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
