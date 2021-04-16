package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 9:58 上午
 */
public class Problem198 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{1,2,3,1};
        System.out.println(solution.rob(nums));

        nums = new int[]{2,7,9,3,1};
        System.out.println(solution.rob(nums));

    }

    private static class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            // 关于状态转义方程的一些解释
            // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]
            // 即, 当前房间可以偷到的最大值, 为前一个房间可以偷到的值,前两个房间可以偷到的值加上当前房间的值中的最大值
            // 对于后者,没有什么疑问, 这是因为无论前两个房间有没有偷, 我都可以偷这个房间
            // 对于前者, 即前一个房间可以偷到的值, 有没有一种情况时, 前一个房间没有偷, 此时最大值应该为dp[i] = dp[i - 1] + nums[i]呢
            // 这种情况不存在, 因为如果这个房间没有被偷, 则dp[i - 1] = dp[i - 2]
            // 如果这个房间被偷了,dp[i] = dp[i - 1] + nums[i] 不可取, 不可以偷相邻两个房间
            for (int i = 1; i < nums.length; i++) {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            }
            return dp[nums.length];
        }
    }
}
