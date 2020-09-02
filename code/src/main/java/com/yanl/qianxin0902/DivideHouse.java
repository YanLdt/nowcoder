package com.yanl.qianxin0902;

/**
 * @author YanL
 * @date 15:55 2020/9/2
 *
 */
public class DivideHouse {

    public int house (int[] person) {
        // write code here
        int len = person.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i ++){
            res[i] = 1;
        }
        for(int i = 1; i < len; i ++){
            if(person[i-1] < person[i]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for(int i = len - 1; i > 0; i --){
            if(person[i-1] > person[i]){
                res[i-1] = Math.max(res[i-1], res[i] + 1);
            }
        }
        int ans = 0;
        for(int i : res){
            ans += i;
        }
        return ans;
    }
}
