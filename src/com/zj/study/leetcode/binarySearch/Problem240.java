package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/7 9:09 上午
 */
public class Problem240 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;
        int targetNumber;

        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        targetNumber = 3;
        System.out.println(solution.searchMatrix(matrix, targetNumber)); // true

        targetNumber = 13;
        System.out.println(solution.searchMatrix(matrix, targetNumber)); // false

        targetNumber = 20;
        System.out.println(solution.searchMatrix(matrix, targetNumber)); // true

        targetNumber = 60;
        System.out.println(solution.searchMatrix(matrix, targetNumber)); // true

        targetNumber = 23;
        System.out.println(solution.searchMatrix(matrix, targetNumber));// true

        matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        targetNumber = 5;
        System.out.println(solution.searchMatrix(matrix, targetNumber)); // true

        matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        targetNumber = -1;
        System.out.println(solution.searchMatrix(matrix, targetNumber)); // false

    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length, col = matrix[0].length;
            for (int i = row - 1, j = 0;; ) {
                if(i < 0 || j > col - 1) {
                    return false;
                }
                if(matrix[i][j] == target) {
                    return true;
                }else if (matrix[i][j] > target) {
                    i--;
                }else {
                    j++;
                }
            }
        }
    }
}
