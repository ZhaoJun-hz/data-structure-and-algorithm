package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/24 8:42 上午
 */
public class Problem62 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 7)); // 28
        System.out.println(solution.uniquePaths(3, 2)); // 3
        System.out.println(solution.uniquePaths(7, 3)); // 28
        System.out.println(solution.uniquePaths(3, 3)); // 6
    }

    private static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
