package com.yanl.nowcoderacm;

import java.util.Scanner;

/**
 * @author YanL
 * @date 1:05 2020/8/10
 *
 * 比如给定范围[2, 22]，数字2在数2中出现了1次，在数12中出现1次，
 * 在数20中出现1次，在数21中出现1次，在数22中出现2次，所以数字2在该范围内一共出现了6次。
 */
public class CountTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(totalCount(left,right));
    }


    public static int totalCount(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += numberOf2(i);
        }
        return res;
    }

    public static int numberOf2(int a){
        int num = 0;
        while (a != 0){
            if(a % 10 == 2){
                num++;
            }
            a /= 10;
        }
        return num;
    }
}
