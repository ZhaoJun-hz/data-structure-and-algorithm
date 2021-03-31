package com.zj.study.leetcode.binarySearch;

/**
 * 题目描述: <a>https://leetcode-cn.com/problems/search-a-2d-matrix/</a>
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 思路: 二分
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 8:04 上午
 */
public class Problem74 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;
        int targetNumber;

        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        targetNumber = 3;
        System.out.println(solution.searchMatrix(matrix, targetNumber));

        targetNumber = 13;
        System.out.println(solution.searchMatrix(matrix, targetNumber));

        targetNumber = 20;
        System.out.println(solution.searchMatrix(matrix, targetNumber));

        targetNumber = 60;
        System.out.println(solution.searchMatrix(matrix, targetNumber));

        targetNumber = 23;
        System.out.println(solution.searchMatrix(matrix, targetNumber));

    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            int col = matrix[0].length;

            int l = 0, r = row - 1, mid;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (matrix[mid][0] < target && matrix[mid][col - 1] < target) {
                    l = mid + 1;
                } else if (matrix[mid][0] > target) {
                    r = mid - 1;
                } else {
                    // 就在这一行
                    return search(matrix[mid], target);
                }
            }

            return false;
        }

        private boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1, mid;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return false;
        }
    }
}
