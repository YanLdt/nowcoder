package com.yanl.wei;

/**
 * @author YanL
 * @date 15:25 2020/10/10
 */
public class Bound extends Thread{
    public static void main(String[] args){
        Bound b = new Bound();
        b.run();
    }
    @Override
    public void start(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
