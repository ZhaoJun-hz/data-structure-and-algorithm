package com.zj.study.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/23 11:10 上午
 */
public class Problem121 {
    public static void main(String[] args) {
        int[] prices;
        Solution solution = new Solution();
        prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
        prices = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length];
            // dp 存储的是当前节点可以获得的最大值
            dp[0] = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
               if(prices[i] > min) {
                   dp[i] = Math.max(dp[i - 1], prices[i] - min);
               }else {
                   dp[i] = dp[i - 1];
                   min = prices[i];
               }
            }
            return dp[prices.length - 1];
        }
    }
}
