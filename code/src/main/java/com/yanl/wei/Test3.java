package com.yanl.wei;

/**
 * @author YanL
 * @date 15:32 2020/10/10
 */
public class Test3 {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        if( j > ++j && i++ == j){
            j+=i;
        }
        System.out.println(j);
        long m = 2;
        float a = 2;
    }
}