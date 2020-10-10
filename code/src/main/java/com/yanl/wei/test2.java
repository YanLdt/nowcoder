package com.yanl.wei;

/**
 * @author YanL
 * @date 15:30 2020/10/10
 */
public class test2 {
    public static void main(String[] args) {
        test2 t = new test2();
        int b = t.get();
        System.out.println(b);
    }
    public int get(){
        try {
            return 1;
        }finally {
            return 2;
        }
    }
}
