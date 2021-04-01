package com.zj.study.leetcode.math;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/surface-area-of-3d-shapes/</a>
 * <p>
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * 请你返回最终这些形体的总表面积。
 * 注意：每个形体的底面也需要计入表面积中。
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 2:08 下午
 */
public class Problem892 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid;

        grid = new int[][]{{2}};
        System.out.println(solution.surfaceArea(grid)); // 10
        grid = new int[][]{{1, 2}, {3, 4}};
        System.out.println(solution.surfaceArea(grid)); // 34
        grid = new int[][]{{1, 0}, {0, 2}};
        System.out.println(solution.surfaceArea(grid));  // 16
        grid = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(solution.surfaceArea(grid)); // 32
        grid = new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(solution.surfaceArea(grid)); // 46
        grid = new int[][]{{1, 0}, {5, 4}};
        System.out.println(solution.surfaceArea(grid)); // 36
    }

    private static class Solution {
        public int surfaceArea(int[][] grid) {
            int result = 0;
            int length = grid.length;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    // 上
                    result += i > 0 ? Math.max(grid[i][j] - grid[i - 1][j], 0) : grid[i][j];
                    // 下
                    result += i < length - 1 ? Math.max(grid[i][j] - grid[i + 1][j], 0) : grid[i][j];
                    // 左
                    result += j > 0 ? Math.max(grid[i][j] - grid[i][j - 1], 0) : grid[i][j];
                    // 右
                    result += j < length - 1 ? Math.max(grid[i][j] - grid[i][j + 1], 0) : grid[i][j];
                    // 底和顶
                    result += 2 * (grid[i][j] > 0 ? 1 : 0);
                }
            }
            return result;
        }
    }
}
