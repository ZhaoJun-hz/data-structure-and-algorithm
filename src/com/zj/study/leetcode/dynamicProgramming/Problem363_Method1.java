package com.zj.study.leetcode.dynamicProgramming;

import com.zj.study.leetcode.content.Solution;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/22 11:32 上午
 */
public class Problem363_Method1 {
    public static void main(String[] args) {
        int[][] matrix;
        int k;
        Solution solution = new Solution();

        matrix = new int[][]{{1, 0, 1}, {0, -2, 3}};
        k = 2;
        System.out.println(solution.maxSumSubmatrix(matrix, k)); // 2

        matrix = new int[][]{{2, 2, -1}};
        k = 3;
        System.out.println(solution.maxSumSubmatrix(matrix, k)); // 3

    }

    private static class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
                }
            }
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = i; l < m; l++) {
                        for (int o = j; o < n; o++) {
                            int cur = dp[l + 1][o + 1] - dp[l + 1][j] - dp[i][o + 1] + dp[i][j];
                            if (cur <= k) {
                                max = Math.max(cur, max);
                            }
                        }
                    }
                }
            }
            return max;
        }
    }


}
