package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/12 11:54 上午
 */
public class Problem1824 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{0, 1, 2, 3, 0};
        System.out.println(solution.minSideJumps(nums));
        nums = new int[]{0, 1, 1, 3, 3, 0};
        System.out.println(solution.minSideJumps(nums));
        nums = new int[]{0, 2, 1, 0, 3, 0};
        System.out.println(solution.minSideJumps(nums));
    }

    private static class Solution {
        public int minSideJumps(int[] obstacles) {
            int[][] dp = new int[obstacles.length][3];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[0][2] = 1;
            for (int i = 1; i < obstacles.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (obstacles[i] == j + 1 || obstacles[i - 1] == j + 1) {
                        dp[i][j] = Integer.MAX_VALUE / 2;
                    } else {
                        int l1 = (j + 1) % 3;
                        int l2 = (j + 2) % 3;
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][l1], dp[i - 1][l2]) + 1);
                    }
                }
            }
            return Math.min(dp[obstacles.length - 1][0], Math.min(dp[obstacles.length - 1][1], dp[obstacles.length - 1][2]));
        }
    }
}
