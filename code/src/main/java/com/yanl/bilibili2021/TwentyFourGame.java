package com.yanl.bilibili2021;

import java.util.ArrayList;

/**
 * @author YanL
 * @date 19:41 2020/8/13
 */
public class TwentyFourGame {
    public boolean isTwentyFour(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i : arr){
            res.add(i);
        }
        return judge(res);
    }

    public boolean judge(ArrayList<Integer> arr){
        if(arr.size() == 0){
            return false;
        }
        if(arr.size() == 1){
            return Math.abs(arr.get(0) - 24) < 1e-6;
        }
        int len = arr.size();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i != j){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    for(int k = 0; k < len; k++){
                        if(k != i && k!=j){
                            tmp.add(arr.get(k));
                        }
                    }
                    for(int k = 0; k < 4; k++){
                        if(k < 2 && j > i){
                            continue;
                        }
                        if(k == 0){
                            tmp.add(arr.get(i) + arr.get(j));
                        }
                        if(k == 1){
                            tmp.add(arr.get(i) * arr.get(j));
                        }
                        if(k == 2){
                            tmp.add(arr.get(i) - arr.get(j));
                        }
                        if(k == 3){
                            if(arr.get(j) != 0){
                                tmp.add(arr.get(i) / arr.get(j));
                            }else {
                                continue;
                            }
                        }
                        if(judge(tmp)){
                            return true;
                        }
                        tmp.remove(tmp.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
