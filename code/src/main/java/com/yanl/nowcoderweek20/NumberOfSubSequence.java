package com.yanl.nowcoderweek20;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 20:23 2020/8/18
 * 第 1 行两个整数 n 和 m，表示名字个数和可爱词汇个数。
 * 接下来 n 行，第 i 行是字符串 Ti ，表示兔子手里的名字。
 * 再接下来 m 行，每行一个字符串 Sj ，表示兔子手里的可爱词汇。
 * 输出共 n 行，每行一个整数，表示每一个名字的可爱度。
 *
 * 5 3
 * Bunny
 * Rabbit
 * TuZi
 * MianZi
 * Sunny
 * uny
 * i
 * a
 *
 * 1
 * 2
 * 1
 * 2
 * 1
 *
 * Bunny 中有 uny 这个可爱词汇
 * Rabbit 中有 i 和 a 这个可爱词汇
 * TuZi 中有 i 这个可爱词汇
 * MianZi中有 i 和 a 这个可爱词汇
 * Sunny中有 uny 这个可爱词汇
 *
 * 与题目无关：
 * //Tuzi(兔子)->MianZi(免子)
 *
 */
public class NumberOfSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];
        String[] son = new String[m];
        for(int i = 0; i < n; i ++){
            str[i] = sc.nextLine();
        }
        for(int i = 0; i < m; i ++){
            son[i] = sc.nextLine();
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            String s = str[i];
            for(String so : son){
                if(s.contains(so)){
                    res[i] += 1;
                }
            }
        }
        for(int i : res){
            System.out.println(i);
        }
    }

}
