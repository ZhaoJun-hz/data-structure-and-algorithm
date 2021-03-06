package com.zj.study.newcoder.basic.class01;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/2 3:51 下午
 */
public class Codeo8_GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L)>> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

}
