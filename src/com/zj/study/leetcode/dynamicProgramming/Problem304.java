package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/22 9:40 上午
 */
public class Problem304 {
    public static void main(String[] args) {
        NumMatrix numMatrix;
        int[][] matrix;

        matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
        System.out.println(numMatrix.sumRegion(0, 0, 0, 0));
        System.out.println(numMatrix.sumRegion(0, 0, 1, 1));
        System.out.println(numMatrix.sumRegion(0, 2, 4, 3));
    }


    private static class NumMatrix {
        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }
    }
}
