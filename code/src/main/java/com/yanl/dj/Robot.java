package com.yanl.dj;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author YanL
 * @date 19:46 2020/8/16
 */
public class Robot {


    public void minTime(int[][] path, int curIndex, int target, int[] flags, int sum){
        int min = Integer.MAX_VALUE;
        if(curIndex == target){
            min = Math.min(min, sum);
        }
        else {
            for(int i = 0; i < path.length; i++){
                if(flags[i] != 1 && path[curIndex][i] != 0 && path[curIndex][i] < min && sum < min){
                    flags[i] = 1;
                    sum += path[curIndex][i];
                    minTime(path, i, target, flags, sum);
                    sum -= path[curIndex][i];
                    flags[i] = 0;
                }
            }
        }
    }
}
