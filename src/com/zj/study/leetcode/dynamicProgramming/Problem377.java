package com.zj.study.leetcode.dynamicProgramming;

import com.zj.study.leetcode.content.Solution;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/24 10:29 上午
 */
public class Problem377 {

    public static void main(String[] args) {
        int[] nums;
        int target;
        Solution solution = new Solution();
        nums = new int[]{1,2,3};
        target = 4;
        System.out.println(solution.combinationSum4(nums, target));

    }

    private static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target ; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j] <= i) {
                        dp[i] += dp[i - nums[j]];
                    }
                }
            }
            return dp[target];
        }
    }
}
