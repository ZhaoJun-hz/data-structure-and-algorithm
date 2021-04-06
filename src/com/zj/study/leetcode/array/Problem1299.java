package com.zj.study.leetcode.array;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 1:57 下午
 */
public class Problem1299 {
    public static void main(String[] args) {
        int[] arr;
        Solution solution = new Solution();

        arr = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(solution.replaceElements(arr)));

        arr = new int[]{400};
        System.out.println(Arrays.toString(solution.replaceElements(arr)));
    }

    private static class Solution {
        public int[] replaceElements(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int max = -1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                arr[i] = max;
            }
            return arr;
        }
    }
}
