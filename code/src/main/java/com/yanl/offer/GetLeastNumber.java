package com.yanl.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author YanL
 * @Time: 23:18 2020/8/6
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 讲道理应该使用堆吧
 *
 */
public class GetLeastNumber {

    /**
     * 通过排序  肯定不是面试官想要的解法
     * @param input 输入数组
     * @param k 最小的k个数
     * @return 返回结果集
     */
    public ArrayList<Integer> getLeastNumberSort(int[] input, int k){
        if(k > input.length){
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 使用堆排序求最小的k个数
     * PriorityQueue默认是用堆来实现的，默认是小根堆，这里使用大根堆实现
     * 小根堆的话需要将全部元素放入堆中
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumberSortHeap(int[] input, int k){
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if(k > len){
            return res;
        }
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int num : input){
            //如果当前堆的大小小于K，则将当前数字放入堆中
            if(queue.size() < k){
                queue.offer(num);
            }else if(num < queue.peek()){
                //如果当前数字小于堆顶元素，则将堆顶元素poll出，放入当前数字，如果当前数字大于堆顶元素，则跳过，所以只要在堆中存放K个元素即可
                queue.poll();
                queue.offer(num);
            }
        }
        res.addAll(queue);
        return res;
    }

    /**
     * 堆排序代码
     * @param input
     * @param i
     * @param len
     */
    public void heapSort(int[] input, int i, int len){

    }
}
