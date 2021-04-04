package com.zj.study.leetcode.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/3 8:57 下午
 */
public class Problem1502 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;

        arr = new int[]{3,5,1};
        System.out.println(solution.canMakeArithmeticProgression(arr));
        arr = new int[]{1,2,4};
        System.out.println(solution.canMakeArithmeticProgression(arr));

    }

    private static class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (diff != arr[i] - arr[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
