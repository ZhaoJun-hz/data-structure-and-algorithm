package com.zj.study.leetcode.math;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/projection-area-of-3d-shapes/</a>
 * <p>
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 * 投影就像影子，将三维形体映射到一个二维平面上。
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回所有三个投影的总面积。
 * <p>
 * 思路: 数学
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 2:38 下午
 */
public class Problem883 {
    public static void main(String[] args) {
        int[][] grid;
        Solution solution = new Solution();

        grid = new int[][]{{2}};
        System.out.println(solution.projectionArea(grid));

        grid = new int[][]{{1, 2}, {3, 4}};
        System.out.println(solution.projectionArea(grid));
    }

    private static class Solution {
        public int projectionArea(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int zArea = 0;
            int yArea = 0;
            int xArea = 0;
            for (int i = 0; i < row; i++) {
                int yMax = -1;
                int xMax = -1;
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] > 0) {
                        zArea++;
                    }
                    if (grid[i][j] > yMax) {
                        yMax = grid[i][j];
                    }
                    if (grid[j][i] > xMax) {
                        xMax = grid[j][i];
                    }
                }
                yArea += yMax;
                xArea += xMax;
            }

            return zArea + yArea + xArea;
        }
    }
}
