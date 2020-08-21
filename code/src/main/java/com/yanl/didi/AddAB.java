package com.yanl.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:36 2020/8/21
 * A+B问题又来了。
 * 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，
 * 现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？
 *
 * 一个正整数n（100<n<2000）。
 *
 * 第一行输出有多少对满足要求的数字。
 * 接下来每一行输出一对abc和acc，以空格分隔。如果没有一对abc和acc的话，则直接输出0即可。如果有多对，请按照abc升序的次序输出。
 *
 * 1068
 * 1
 * 524 544
 *
 * 暴力就完事了
 */
public class AddAB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        add(n);
//        int c = (n % 10) / 2;
//        int a = 0;
//        int b = 0;
//        int resA = 0;
//        int resB = 0;
//        if(n < 200){
//            a = 0;
//            if(c == 0){
//                System.out.println(0);
//                return;
//            }
//            b = (n - c * 10 + c) / 10;
//            if(b == c){
//                System.out.println(0);
//                return;
//            }
//            if(b == 0){
//                System.out.println(0);
//                return;
//            }
//            resA = a * 100 + b * 10 + c;
//            resB = a * 100 + c * 10 + c;
//        }else {
//            a = n / 200;
//            if(a == c){
//                System.out.println(0);
//                return;
//            }
//            b = (n - (a * 100 + c * 10 + c) - a * 100) / 10;
//            if(a == b || b == c){
//                System.out.println(0);
//                return;
//            }
//            resA = a * 100 + b * 10 + c;
//            resB = a * 100 + c * 10 + c;
//        }
//        System.out.println(1);
//        System.out.println(resA + " " + resB);
    }

    public static void add(int n){
        //a最小为1 220 100+120
        //a最大为9 1966 978+988
        if(n < 220 || n > 1966){
            System.out.println(0);
            return;
        }
        if(n == 220){
            System.out.println(1);
            System.out.println(120 + " " + 100);
            return;
        }
        if(n == 1966){
            System.out.println(1);
            System.out.println(978 + " " + 988);
        }
        int a = 0, b = 0, c = 0;
        int count = 0;
        ArrayList<String> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k <= 9; k++){
                    if(200 * i + 10 * j + 12 * k == n && i != j && j != k && i != k){
                        count++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i).append(j).append(k).append(" ").append(i).append(k).append(k);
                        res.add(sb.toString());
                    }
                }
            }
        }
        System.out.println(count);
        for(String s : res){
            System.out.println(s);
        }
    }

}
