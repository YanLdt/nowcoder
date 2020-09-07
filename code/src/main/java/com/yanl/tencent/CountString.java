package com.yanl.tencent;

import java.util.*;

/**
 * @author YanL
 * @date 20:50 2020/9/6
4 2
1
2
3
4

1 1
2 1
1 1
2 1

4 2
1
1
2
3

1 2
2 1
2 1
3 1
 *
 */
public class CountString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i ++){
            String s = sc.nextLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int len = map.size();
        List<Map.Entry<String, Integer>> tmp = new ArrayList<>(map.entrySet());
        Collections.sort(tmp, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i1 = o1.getValue();
                int i2 = o2.getValue();
                if(i1 != i2){
                    return i2 - i1;
                }else {
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    if(s1.length() == s2.length()){
                        return s1.compareTo(s2);
                    }else {
                        return s1.length() - s2.length();
                    }
                }
            }
        });
        List<Map.Entry<String, Integer>> tmp2 = new ArrayList<>(map.entrySet());
        Collections.sort(tmp2, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i1 = o1.getValue();
                int i2 = o2.getValue();
                if(i1 != i2){
                    return i1 - i2;
                }else {
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    if(s1.length() == s2.length()){
                        return s1.compareTo(s2);
                    }else {
                        return s1.length() - s2.length();
                    }
                }
            }
        });


        for(int i = 0; i < k; i ++){
            Map.Entry<String, Integer> entry = tmp.get(i);
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }
        for(int i = 0; i < k; i ++){
            Map.Entry<String, Integer> entry = tmp2.get(i);
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }
    }
}
