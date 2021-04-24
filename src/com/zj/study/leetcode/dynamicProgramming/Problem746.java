package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/23 2:45 下午
 */
public class Problem746 {

    public static void main(String[] args) {
        int[] cost;
        Solution solution = new Solution();
        cost = new int[]{10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost));

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    private static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
                // 从下标i - 2 花费 cost[i - 2] 或者 从下标i - 1 花费 cost[i- 1]达到
                dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            }
            return dp[cost.length];
        }
    }
}
