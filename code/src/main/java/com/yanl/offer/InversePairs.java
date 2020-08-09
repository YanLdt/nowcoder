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
 * 考虑使用归并，将数组分为两个子数组，求出子数组的逆序对数
 *
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        int[] array1 = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int len = array.length;
        int[] res = new int[len];

        System.out.println(pairCounts(array1));
        System.out.println(pairCountsMerge(array1));
    }

    public static int pairCountsMerge(int[] array){

        int len = array.length;
        int[] res = new int[len];
        System.arraycopy(array, 0, res, 0, len);
        return (int) merge(array, res, 0, len-1);
    }

    /**
     * 通过归并将数组分为两个数组分别计算两个数组各自的逆序对以及合并两个子数组所计算得到的逆序对
     * 注意把返回值都设为long！！！！！！！！！！
     * @param arr 原始数组
     * @param res 排序后的数组
     * @param start 开始索引
     * @param end 结束索引
     * @return 返回逆序对数
     */
    public static long merge(int[] arr, int[] res, int start, int end){
        int MOD = 1000000007;
        if(start == end){
            return 0;
        }
        //分组中间点
        int mid = (end + start) / 2;
        //求左边的逆序对数
        long left = merge(arr, res, start, mid);
        //右边的逆序对数
        long right = merge(arr, res, mid + 1, end);
        //初始化为左边数组的右边界
        int i = mid;
        //初始化右边数组的有边界
        int j = end;
        //最终数组的索引
        int resIndex = end;
        //两个数组排序所生成的逆序对数
        long count = 0;
        //都从右边界开始算起，如果左边值大于右边则说明 左边有边界的值大于右边数组的所有数字，因此逆序对数为右边数组长度
        while (i >= start && j > mid){
            if(arr[i] > arr[j]){
                res[resIndex--] = arr[i--];
                count += j - mid;
            }else {
                res[resIndex--] = arr[j--];
            }
        }
        //右边数组走完了之后把左边数组剩余数字拷贝到排序数组
        for(; i >= start; i--){
            res[resIndex--] = arr[i];
        }
        for(; j > mid; j--){
            res[resIndex--] = arr[j];
        }
        if (end + 1 - start >= 0) {
            System.arraycopy(res, start, arr, start, end + 1 - start);
        }
        return (left + right + count) % MOD ;
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
