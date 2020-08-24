package com.yanl.ali0824;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:07 2020/8/24
 * [1,A]选出x,[1,B]选出y
 * 使x/y=a/b且xy乘积最大
 */
public class MaxXY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long tmp = 0;
        boolean flag = false;
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 1; i <= A; i++){
            for(int j = 1; j <= B; j++){
                if(i * b == j * a){
                    int[] temp = new int[3];
                    temp[0] = i;
                    temp[1] = j;
                    temp[2] = i*j;
                    res.add(temp);
                    flag = true;
                }
            }
        }
        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        if(flag){
            System.out.println(res.get(0)[0] + " " + res.get(0)[1]);
        }else {
            System.out.println("0 0");
        }
    }
}
