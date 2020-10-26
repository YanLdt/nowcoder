package com.yanl.micpc;

import java.util.Scanner;

/**
 * @author YanL
 * @date 15:24 2020/10/25
 */
public class SmartBrowser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int sum = 0;
        int count = 0;
        int tmp = 0;
        for(char c : chars){
            if(c == 'v'){
                tmp = 2 * count - 1;
                sum += tmp;
                tmp = 0;
                count = 0;
            }else {
                count ++;
            }
        }
        sum = count == 0 ? sum : sum + 2 * count - 1;
        System.out.println(sum);
    }
}
