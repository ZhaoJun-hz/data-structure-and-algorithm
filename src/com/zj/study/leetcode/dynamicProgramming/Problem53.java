package com.zj.study.leetcode.dynamicProgramming;


/**
 * @author zj
 * @desiription:
 * @date 2021/4/23 3:14 下午
 */
public class Problem53 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
        nums = new int[]{1};
        System.out.println(solution.maxSubArray(nums));
        nums = new int[]{0};
        System.out.println(solution.maxSubArray(nums));
        nums = new int[]{-1};
        System.out.println(solution.maxSubArray(nums));
    }

    private static class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            int max = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(dp[i - 1] + nums[i] < nums[i]) {
                    dp[i] = nums[i];
                }else {
                    dp[i] = dp[i - 1] + nums[i];
                }
                if(dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
