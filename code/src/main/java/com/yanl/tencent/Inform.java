package com.yanl.tencent;

import java.util.*;

/**
 * @author YanL
 * @date 20:26 2020/9/6
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2
 *
 * 7
 *
 */
public class Inform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Set<Integer>> list = new ArrayList<>();
        int f = 0;
        for(int i = 0; i < m; i ++){
            Set<Integer> setTmp = new HashSet<>();
            int x = sc.nextInt();
            for(int j = 0; j < x; j ++){
                setTmp.add(sc.nextInt());
            }
            if(setTmp.contains(0)){
                f = i;
            }
            list.add(setTmp);
        }
        Set<Integer> set0 = list.get(f);
        Set<Integer> res = new HashSet<>();
        for(Set<Integer> set : list){
            for(int i : set0){
                if(set.contains(i)){
                    for(int j : set){
                        res.add(i);
                    }
                }
            }
        }
        System.out.println(res.size());
    }
}
