package com.yanl.offer;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数，数组中的一个或连续多个整数组成一个连续子数组，
 * 求所有子数组的和的最大数
 * {1， -2， 3， 10， -4， 7， 2， -5}
 * 3， 10， -4， 7， 2
 * 18
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(arr, arr.length));
    }

    /**
     * 从前往后遍历，如果和小于0则舍弃，继续累加后面的
     * @param arr
     * @param len
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] arr, int len){
        if(arr == null || len == 0){
            return 0;
        }
        int sum = 0;
        int greater = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            //判断当前元素之前的总和是否小于0，小于0则舍弃，直接等于当前值
            if(sum <= 0){
                sum = arr[i];
            }else{
                //否则的话就继续累加
                sum += arr[i];
            }
            //保存最大值
            if(greater < sum){
                greater = sum;
            }
        }
        return greater;
    }

}
