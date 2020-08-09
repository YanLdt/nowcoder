package com.yanl.offer;

/**
 * @author YanL
 * @date 15:23 2020/8/8
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 * 1,2,3,4,5,6,7,0
 *
 * 7
 *
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(pairCounts(array));
    }

    /**
     * 暴力法只能过50%
     * 提示超时
     * @param array
     * @return
     */
    public static int pairCounts(int[] array){
        int res = 0;
        for(int i = 0; i < array.length-1; i++){
            res += singleData(i, array);
        }
        return res % 1000000007;
    }

    /**
     * 计算当前元素与后面元素之家的逆序对
     * @param i
     * @param array
     * @return
     */
    public static int singleData(int i, int[] array){
        int cnt = 0;
        for(int j = i+1; j < array.length; j++){
            if(array[j] < array[i]){
                cnt++;
            }
        }
        return cnt;
    }

}
