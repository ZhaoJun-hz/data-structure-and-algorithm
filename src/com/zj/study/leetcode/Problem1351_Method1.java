package com.zj.study.leetcode;


public class Problem1351_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {8, 7, 6, 5, 4, 3, 2, 1, 0},
                {7, 6, 5, 4, 3, 2, 1, 0, -1},
                {6, 5, 4, 3, 2, 1, 0, -1, -2},
                {5, 4, 3, 2, 1, 0, -1, -2, -3},
                {4, 3, 2, 1, 0, -1, -2, -3, -4},
                {3, 2, 1, 0, -1, -2, -3, -4, -5}
        };
        // int[][] array = {
        //         {4,3,2},
        //         {3,2,1},
        //         {1,1,-1},
        //         {-1,-1,-2}
        // };
        System.out.println("solution.countNegatives(array) = " + solution.countNegatives(array));
    }

    private static class Solution {
        public int countNegatives(int[][] grid) {
            return solve(0, grid.length - 1, 0, grid[0].length - 1, grid);
        }

        private int solve(int l, int r, int L, int R, int[][] grid) {
            if (l > r) return 0;
            int mid = l + ((r - l) >> 1), pos = -1;
            for (int i = L; i <= R; i++) {
                if (grid[mid][i] < 0) {
                    pos = i;
                    break;
                }
            }
            int ans = 0;
            if (pos >= 0) {
                ans += grid[0].length - pos;
                ans += solve(l, mid - 1, pos, R, grid);
                ans += solve(mid + 1, r, L, pos, grid);
            } else {
                ans += solve(mid + 1, r, L, R, grid);
            }
            return ans;
        }
    }
}

