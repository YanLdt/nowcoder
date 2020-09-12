package com.yanl.huawei0909;

/**
 * @author YanL
 * @date 19:36 2020/9/9
 */
public class PerfectPerm {
    public static void main(String[] args) {
        int[] perfectOne = new int[]{1, 2, 3};
        int[] perfectTwo = new int[]{3, 2, 1};
        int[] arr1 = new int[]{1, 2, 1, 2, 3, 3};
        int[] arr2 = new int[]{5, 4, 3, 2, 1, 1};
        System.out.println(find(perfectOne, perfectTwo, arr1, arr2, 3, 6));
    }

    public static int find(int[] perfectOne, int[] perfectTwo, int[] arrOne,
                           int[] arrTwo, int perLen, int arrLen){
        StringBuilder perfect1 = new StringBuilder();
        StringBuilder perfect2 = new StringBuilder();
        StringBuilder arr1 = new StringBuilder();
        StringBuilder arr2 = new StringBuilder();
        for(int i = 0; i < perLen; i ++){
            perfect1.append(perfectOne[i]);
            perfect2.append(perfectTwo[i]);
        }
        for(int i = 0; i < arrLen; i ++){
            arr1.append(arrOne[i]);
            arr2.append(arrTwo[i]);
        }

        for(int i = 0; i < arrLen - perLen; i ++){
            System.out.println(arr1.substring(i, i + perLen));
            if(arr1.substring(i, i + perLen).equals(perfect1.toString()) &&
            arr2.substring(i, i + perLen).equals(perfect2.toString())){
                return i + 1;
            }
        }
        return 0;
    }
}
