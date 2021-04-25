package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/24 8:51 上午
 */
public class Problem63 {

    public static void main(String[] args) {
        int[][] obstacleGrid;
        Solution solution = new Solution();
        obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid)); // 2
        obstacleGrid = new int[][]{{0,1},{0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid)); // 1
        obstacleGrid = new int[][]{{1,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid)); // 0
    }

    private static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if(flag) {
                    dp[i][0] = 0;
                }else {
                    if (obstacleGrid[i][0] != 1) {
                        dp[i][0] = 1;
                    } else {
                        flag = true;
                        dp[i][0] = 0;
                    }
                }
            }
            flag = false;
            for (int i = 0; i < n; i++) {
                if(flag) {
                    dp[0][i] = 0;
                }else {
                    if (obstacleGrid[0][i] != 1) {
                        dp[0][i] = 1;
                    } else {
                        flag = true;
                        dp[0][i] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if(obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }else {
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
