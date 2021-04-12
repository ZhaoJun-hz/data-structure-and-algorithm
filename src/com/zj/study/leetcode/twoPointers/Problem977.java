package com.zj.study.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/9 1:40 下午
 */
public class Problem977 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();

        // nums = new int[]{-4, -1, 0, 3, 10};
        // System.out.println(Arrays.toString(solution.sortedSquares(nums)));

        // nums = new int[]{-7, -3, 2, 3, 11};
        // System.out.println(Arrays.toString(solution.sortedSquares(nums)));

        // nums = new int[]{0, 1, 2, 3, 4, 5};
        // System.out.println(Arrays.toString(solution.sortedSquares(nums)));

        nums = new int[]{-5, -4, -3, -2, -1};
        System.out.println(Arrays.toString(solution.sortedSquares(nums)));

    }

    private static class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];
            int position;
            for (position = 0; position < nums.length; position++) {
                if (nums[position] >= 0) {
                    break;
                }
            }
            int index = 0;
            int i;
            int j;
            for (i = position - 1, j = position; i >= 0 && j < nums.length; ) {
                if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                    result[index++] = nums[i] * nums[i];
                    i--;
                } else if (Math.abs(nums[i]) == Math.abs(nums[j])) {
                    result[index++] = nums[i] * nums[i];
                    result[index++] = nums[j] * nums[j];
                    i--;
                    j++;
                } else {
                    result[index++] = nums[j] * nums[j];
                    j++;
                }
            }
            while (i >= 0) {
                result[index++] = nums[i] * nums[i];
                i--;
            }
            while (j < nums.length) {
                result[index++] = nums[j] * nums[j];
                j++;
            }
            return result;
        }
    }
}
