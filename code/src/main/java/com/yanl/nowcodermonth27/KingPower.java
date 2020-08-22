package com.yanl.nowcodermonth27;

import java.util.Scanner;

/**
 * @author YanL
 * @date 23:42 2020/8/22
 * king放礼炮 kinging放两支礼炮、
 * 求给定的字符串最多能放多少发礼炮
 4
 king
 * 1
 */
public class KingPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int a = 0, b = 0, c = 0, d = 0;
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        for(char ch : chars){
            if(ch == 'k'){
                a++;
            }
            if(ch == 'i'){
                b++;
            }
            if(ch == 'n'){
                c++;
            }
            if(ch == 'g'){
                d++;
            }
        }
        int min = Math.min(Math.min(b, c), d);
        if(a * 2 >= min){
            System.out.println(min);
        }else {
            System.out.println(a * 2);
        }
    }
}
