package com.yanl.jd0827;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:34 2020/8/27
 * 自从学了素数以后，小明喜欢上了数字2、3和5。当然，如果一个数字里面只出现2、3和5这三个数字，
 * 他也一样喜欢，例如222、2355、223355。
 * 现在他希望你能够帮他编写一个程序，快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5。
 *
 */
public class NumberOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            sb.append((n-1) % 3);
            n = (n-1) / 3;
        }
        sb.reverse();
        int len = sb.length();
        char[] chars = sb.toString().toCharArray();
        for(int i = 0; i < len; i ++){
            if(chars[i] == '0'){
                sb.setCharAt(i, '2');
            }else if(chars[i] == '1'){
                sb.setCharAt(i, '3');
            }else if(chars[i] == '2'){
                sb.setCharAt(i, '5');
            }
        }
        System.out.println(sb.toString());
    }
}
