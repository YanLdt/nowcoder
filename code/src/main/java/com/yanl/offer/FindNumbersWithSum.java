package com.yanl.offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author YanL
 * @date 13:54 2020/8/10
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    /**
     * 使用双指针，前后两个指针，记录符合要求的结果
     * 再把结果集按乘积顺序排序
     * 输出结果集的第一个子集
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        int len = array.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = len - 1;
        int tmpSum = 0;
        while (left <= right){
            tmpSum = array[left] + array[right];
            if(tmpSum < sum){
                tmpSum -= array[left];
                left++;
            }else if(tmpSum > sum){
                tmpSum -= array[right];
                right--;
            }else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(array[left]);
                tmp.add(array[right]);
                res.add(tmp);
                left++;
                right--;
            }
        }
        if(res.size() != 0){
            //按每个子数组的乘积大小进行排序
            res.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(0)*o1.get(1) - o2.get(0)*o2.get(1);
                }
            });
            return res.get(0);
        }
        return new ArrayList<>();

    }
}
