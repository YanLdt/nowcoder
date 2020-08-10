package com.yanl.offer;

import java.util.Arrays;

/**
 * @author YanL
 * @date 15:24 2020/8/10
 * 从扑克牌中随机抽取5张牌，判断是不是一个顺子，即是不是连续的
 * 2-10为数字本身，A为1,J-11,Q-12,K-13,大小王可以看成任意数字可以看做0
 * 判断0的个数个数组间距的大小
 */
public class ContinuePoke {
    public boolean isContinuous(int [] numbers) {

        int len = numbers.length;
        if(len == 0){
            return false;
        }
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int gap = 0;
        for(int num : numbers){
            if(num == 0) {
                numberOfZero++;
            }
        }
        int left = numberOfZero;
        int right = left+1;
        while (right < len){
            //如果存在相等的数字则不可能为顺子
            if(numbers[right] == numbers[left]){
                return false;
            }
            gap += numbers[right] - numbers[left] - 1;
            left = right;
            right++;
        }
        return numberOfZero >= gap;

    }
}
