package com.zj.study.leetcode.binarySearch;

public class Problem1351_Method2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] array = {
        //         {9, 8, 7, 6, 5, 4, 3, 2, 1},
        //         {8, 7, 6, 5, 4, 3, 2, 1, 0},
        //         {7, 6, 5, 4, 3, 2, 1, 0, -1},
        //         {6, 5, 4, 3, 2, 1, 0, -1, -2},
        //         {5, 4, 3, 2, 1, 0, -1, -2, -3},
        //         {4, 3, 2, 1, 0, -1, -2, -3, -4},
        //         {3, 2, 1, 0, -1, -2, -3, -4, -5}
        // };
        // int[][] array = {
        //         {4,3,2},
        //         {3,2,1},
        //         {1,1,-1},
        //         {-1,-1,-2}
        // };
        int[][] array = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println("solution.countNegatives(array) = " + solution.countNegatives(array));
    }

    private static class Solution {
        public int countNegatives(int[][] grid) {
            int sum = 0;
            int row = grid.length;
            int col = grid[0].length;
            int left = 0;
            for (int i = row - 1; i >= 0; i--) {
                for (int j = left; j < col; j++) {
                    if (grid[i][j] < 0) {
                        sum += col - j;
                        left = j;
                        break;
                    }
                }
                if (left == col) {
                    break;
                }
            }
            return sum;
        }
    }
}

