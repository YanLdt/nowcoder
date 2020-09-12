package com.yanl.netease20210912;

import java.util.*;

/**
 * @author YanL
 * @date 15:18 2020/9/12
 *
 */
public class Cherry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> mapLeft = new HashMap<>();
        Map<Integer, Integer> mapRight = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i ++){
            String[] s = sc.nextLine().split(" ");
            int fa = Integer.parseInt(s[0]);
            set.add(fa);
            String direction = s[1];
            int son = Integer.parseInt(s[2]);
            if("left".equals(direction)){
                mapLeft.put(fa, son);
            }else {
                mapRight.put(fa, son);
            }
        }
        int res = 0;
        for(int i : set){
            if(mapLeft.containsKey(i) && mapRight.containsKey(i)){
                if(!set.contains(mapLeft.get(i)) && !set.contains(mapRight.get(i))){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}