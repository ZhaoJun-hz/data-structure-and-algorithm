package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 5:27 下午
 */
public class Problem1588 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(solution.sumOddLengthSubarrays(arr));
        arr = new int[]{1, 2};
        System.out.println(solution.sumOddLengthSubarrays(arr));
        arr = new int[]{1, 2, 3};
        System.out.println(solution.sumOddLengthSubarrays(arr));
        arr = new int[]{1, 2, 3, 4};
        System.out.println(solution.sumOddLengthSubarrays(arr));
    }

    private static class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int[] sum = new int[arr.length + 1];
            sum[0] = 0;
            for (int i = 0; i < arr.length; i++) {
                sum[i + 1] = sum[i] + arr[i];
            }
            int result = sum[arr.length];
            for (int i = 2; i < arr.length; i += 2) {
                for (int j = 0; j + i < arr.length; j++) {
                    result += sum[j + i + 1] - sum[j];

                }
            }
            return result;
        }
    }
}
