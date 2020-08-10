package com.yanl.offer;

/**
 * @author YanL
 * @date 22:29 2020/8/10
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]A[1]...A[i-1]A[i+1]...A[n-1]。不能使用除法。
 * C[i] = A[0]A[1]....A[i-1] = C[i-1]*A[i-1]
 * D[i] = A[i+1]......A[n-1] = D[i+1]*A[i+1]
 */
public class MultiplyArray {
    public int[] multiply(int[] A){
        if(A == null || A.length <= 0){
            return null;
        }

        int[] C = new int[A.length];
        C[0] = 1;
        for(int i = 1; i < C.length; i++){
            C[i] = C[i-1] * A[i-1];
        }
        int[] D = new int[A.length];
        D[D.length - 1] = 1;
        for(int i = D.length-2; i >= 0; i--){
            D[i] = D[i+1] * A[i+1];
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = C[i] * D[i];
        }
        return res;
    }
}
