package com.zj.study.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/23 9:13 上午
 */
public class Problem368 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{1,2,3};
        System.out.println(solution.largestDivisibleSubset(nums));

        nums = new int[]{1,2,4,8};
        System.out.println(solution.largestDivisibleSubset(nums));

    }

    private static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
           Arrays.sort(nums);
           int[] dp = new int[nums.length];
           Arrays.fill(dp, 1);
           int maxSize = 1;
           int maxValue = nums[0];
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if(dp[i] > maxSize) {
                    maxValue = nums[i];
                    maxSize = dp[i];
                }
            }

            List<Integer> result = new ArrayList<>();
            if (maxSize == 1) {
                result.add(nums[0]);
                return result;
            }

            for (int i = nums.length - 1; i >= 0 ; i--) {
                if(dp[i] == maxSize && maxValue % nums[i] == 0) {
                    result.add(nums[i]);
                    maxSize --;
                    maxValue = nums[i];
                }
            }
            return result;
        }
    }
}
