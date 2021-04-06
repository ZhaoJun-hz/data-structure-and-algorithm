package com.zj.study.leetcode.array;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 1:46 下午
 */
public class Problem1365 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();

        nums = new int[]{8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));

        nums = new int[]{6, 5, 4, 8};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));

        nums = new int[]{7, 7, 7};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));
    }

    private static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int temp = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        temp ++;
                    }
                }
                result[i] = temp;
            }
            return result;
        }
    }
}
