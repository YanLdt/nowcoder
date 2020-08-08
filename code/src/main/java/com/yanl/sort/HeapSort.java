package com.yanl.sort;

import java.util.Arrays;

/**
 * @author YanL
 * @date 11:06 2020/8/8
 * 堆排序属于树形选择排序
 * 堆的定义是：具有n个元素的序列，当且仅当ai>(a2i),ai>(a2i+1)
 * 大顶堆是堆顶元素为最大值，左子树和右子树都小于堆顶元素
 * 完全二叉树
 * 除最后一层外，其他各层节点数都达到最大值，且最后一层节点都集中在左边
 * 完全二叉树是子节点是2i+1和2i+2
 */
public class HeapSort {

    public static void main(String[] args){
        int[] arr = new int[]{10, 5, 4, 2, 8, 3, 7, 6};
        int len = arr.length;
        //循环建堆
        for(int i = 0; i < len; i++){
            //建堆
            builtMaxHeap(arr, len - 1 -i);
            //交换堆顶和最后一个元素  建堆之后堆顶永远是最大的，所以要交换到数组末尾
            swap(arr, 0, len - 1 - i);
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 对数组从0到len建大顶堆
     * @param arr
     * @param len
     */
    public static void builtMaxHeap(int[] arr, int len){
        //从最后一个节点的父节点开始
        for(int i = (len-1) / 2; i >= 0; i--){
            //cur为当前正在判断的父节点
            int cur = i;
            //如果当前节点的子节点存在的话
            while (2 * cur + 1 <= len){
                //k节点的左子节点
                int biggerIndex = 2 * cur + 1;
                //如果左子节点的序号小于序列最后一个元素的序号，说明右节点也存在
                if(biggerIndex < len){
                    //判断左右子节点哪个大
                    if(arr[biggerIndex] < arr[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                //比较当前父节点与最大子节点的大小
                if(arr[cur] < arr[biggerIndex]){
                    swap(arr, cur, biggerIndex);
                    //接着循环保证当前节点的值大于其左右子节点的值
                    cur = biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
