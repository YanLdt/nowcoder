package com.yanl;

/**
 * @author yanl
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(6&1);
        int a = testFinally();
        System.out.println(a);
    }

    public static int testFinally(){
        int i = 0;
        try{
            return i;
        }finally {
            i=i+1;
        }
    }
}
