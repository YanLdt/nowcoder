package com.yanl.ke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author YanL
 * @date 19:26 2020/8/11
 * 我觉得两种颜色就够了
 */
public class Paint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i< n; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            System.out.println(new Paint().color(h, w));
        }

    }

    public int color(int n, int m){
        if(n % 2 == 0 || m % 2 == 0){
            return 2;
        }
        ArrayList<Integer> n1 = get(n);
        ArrayList<Integer> n2 = get(m);
        n1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i = 1; i < n1.size(); i++){
            if(n2.contains(i)){
                return i;
            }
        }
        return 0;
    }
    public ArrayList<Integer> get(int n){
        ArrayList<Integer> res = new ArrayList<>();
        int i = 2;
        do {
            if (n % i == 0) {
                res.add(i);
                n /= i;
            } else {
                i++;
            }
        } while (n != 1);
        return res;
    }
}
