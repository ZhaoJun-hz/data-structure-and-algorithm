package com.zj.study.leetcode.array;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 7:55 下午
 */
public class Problem832 {
    public static void main(String[] args) {
        int[][] image;
        Solution solution = new Solution();
        image = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(solution.flipAndInvertImage(image)));
    }

    private static class Solution {
        public int[][] flipAndInvertImage(int[][] image) {
            int row = image.length;
            int col = image[0].length;
            int[][] result = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result[i][j] = image[i][col - 1 - j] == 0 ? 1 : 0;
                }
            }
            return result;
        }
    }
}
