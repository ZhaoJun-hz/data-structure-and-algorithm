package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 7:46 下午
 */
public class Problem1534 {

    public static void main(String[] args) {
        int[] arr;
        int a, b, c;
        Solution solution = new Solution();

        arr = new int[]{3, 0, 1, 1, 9, 7};
        a = 7;
        b = 2;
        c = 3;
        System.out.println(solution.countGoodTriplets(arr, a, b, c));

        arr = new int[]{1, 1, 2, 2, 3};
        a = 0;
        b = 0;
        c = 1;
        System.out.println(solution.countGoodTriplets(arr, a, b, c));
    }

    private static class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[i] - arr[j]) > a) {
                            continue;
                        }
                        if (Math.abs(arr[j] - arr[k]) > b) {
                            continue;
                        }
                        if (Math.abs(arr[i] - arr[k]) > c) {
                            continue;
                        }
                        result++;
                    }
                }
            }
            return result;
        }
    }
}
