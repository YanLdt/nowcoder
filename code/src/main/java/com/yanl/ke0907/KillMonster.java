package com.yanl.ke0907;

import java.util.Scanner;

/**
 * @author YanL
 * @date 16:28 2020/9/7
 *
 */
public class KillMonster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] subBlood = new int[2 * k];
        for(int i = 0 ; i < 2 * k; i ++){
            subBlood[i] = sc.nextInt();
        }
        int[] addBlood = new int[2 * k];
        for(int i = 0; i < 2 * k; i ++){
            addBlood[i] = sc.nextInt();
        }
        int initBlood = 0;
        int minBlood = Integer.MAX_VALUE;
        int left = k - 1;
        int right = k;
        while (left >= 0 || right < 2 * k){
            if (left > 0 && right < 2 * k){
                if(addBlood[left] - subBlood[left] > addBlood[right] - subBlood[right]){
                    initBlood -= subBlood[left];
                    minBlood = Math.min(initBlood, minBlood);
                    initBlood += addBlood[left];
                    left--;
                }else{
                    initBlood -= subBlood[right];
                    minBlood = Math.min(initBlood, minBlood);
                    initBlood += addBlood[right];
                    right++;
                }
            }else if(left < 0){
                initBlood -= addBlood[right];
                minBlood = Math.min(initBlood, minBlood);
                initBlood += addBlood[right];
                right++;
            }else {
                initBlood -= subBlood[left];
                minBlood = Math.min(initBlood, minBlood);
                initBlood += addBlood[left];
                left--;
            }
        }
        if(minBlood > 0) {
            System.out.println(0);
        }else {
            System.out.println(-minBlood+1);
        }
    }
}
