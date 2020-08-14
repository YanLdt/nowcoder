package com.yanl.ali0814;

import java.util.Scanner;

/**
 * @author YanL
 * @date 19:33 2020/8/14
 */
public class SimilarString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 1;
            System.out.println(new SimilarString().compute(chars, left, right));
        }
    }

    public int compute(char[] chars, int i, int j){
        if(chars.length == 0){
            return 0;
        }
        int res = 0;
        int len = chars.length;
        while (j<len){
            if((chars[i] == 0 && chars[j] == 9) || (chars[i] ==9 && chars[j] == 0)){
                chars[i] -= '1';
                chars[j] += '1';
                res++;
                compute(chars, i+1, j+1);
            }
        }
        return res % 1000000007;
    }
}
