package com.yanl.offer;

/**
 * @author YanL
 * @date 10:13 2020/8/10
 * 统计一个数字在排序数组中出现的次数。
 * 排序数组则使用二分查找会快一些
 * 找到数组中第一个K和最后一个K
 */
public class GetNumberOfK {

    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,10};
        int k = 8;
        System.out.println(getNumberOfK(array, k));
    }

    public static int getNumberOfK(int[] array, int k){
        int len = array.length;
        if(len == 0){
            return 0;
        }
        int first = getFirstK(array, k, 0, len-1);
        int last = getLastK(array, k, 0, len-1);
        System.out.println(first + " " + last);
        if(first >= 0 && last >= 0) {
            return last - first + 1;
        }
        return 0;
    }

    /**
     * 获取第一个K
     * 递归
     * @param arr
     * @param k
     * @param start
     * @param end
     * @return
     */
    public static int getFirstK(int[] arr, int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        //中位数小于K，大于K,等于K三种情况
        if(arr[mid] < k){
            start = mid + 1;
        }else if(arr[mid] > k){
            end = mid - 1;
        }else{
            //等于K，如果前一个元素不为K
            if(mid > 0 && arr[mid-1] != k || mid == 0){
                return mid;
            }else {
                end = mid - 1;
            }
        }
        return getFirstK(arr, k, start, end);
    }

    /**
     * 获取最后一个K所在的位置
     * @param arr
     * @param k
     * @param start
     * @param end
     * @return
     */
    public static int getLastK(int[] arr, int k, int start, int end){
        while (start <= end){
            int mid = (start + end) >> 1;
            if(arr[mid] < k){
                start = mid + 1;
            }else if(arr[mid] > k){
                end = mid - 1;
            }else {
                //等于K，如果后一个元素不为K
                if(mid < arr.length-1 && arr[mid+1] != k || mid == arr.length-1){
                    return mid;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}
