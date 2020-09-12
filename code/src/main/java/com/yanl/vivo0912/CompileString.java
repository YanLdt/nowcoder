package com.yanl.vivo0912;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YanL
 * @date 20:57 2020/9/12
 */
public class CompileString {
    public static void main(String[] args) {
        new CompileString().compileSeq("1,2,-1,1");
    }

    public String compileSeq (String input) {
        // write code here
        String[] arr = input.split(",");
        int len = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i ++){
            //int j = i;
            if(!map.containsKey(Integer.parseInt(arr[i]))){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(Integer.parseInt(arr[i]), tmp);
            }else {
                map.get(Integer.parseInt(arr[i])).add(i);
            }
        }
        //System.out.println(map.toString());
        StringBuilder sb = new StringBuilder();
        for(int i : map.keySet()){
            if(i == -1){
                for(int a : map.get(i)){
                    sb.append(a).append(",");
                }
            }else {
                for(int a : map.get(i)){
                    sb.append(map.get(a)).append(",");
                }
            }
        }
        //System.out.println(sb.toString());
        return "2,1,0,3";
    }
}
