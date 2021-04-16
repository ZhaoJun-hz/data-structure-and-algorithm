package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 10:22 上午
 */
public class Problem213 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{2,3,2};
        System.out.println(solution.rob(nums));

        nums = new int[]{1,2,3,1};
        System.out.println(solution.rob(nums));

        nums = new int[]{0};
        System.out.println(solution.rob(nums));
    }

    private static class Solution {
        public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];
            int[] dp1 = new int[nums.length];
            int[] dp2 = new int[nums.length];
            dp1[0] = 0;
            dp1[1] = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                dp1[i + 1] = Math.max(dp1[i], dp1[i - 1] + nums[i]);
            }

            dp2[0] = 0;
            dp2[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
            }
            return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
        }
    }
}
