package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 5:15 下午
 */
public class Problem1572 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat;
        mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.diagonalSum(mat));

        mat = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };
        System.out.println(solution.diagonalSum(mat));
    }

    private static class Solution {
        public int diagonalSum(int[][] mat) {
            // 4 -> 0,0 1,1 2,2 3,3
            // 4 -> 3,0 2,1 3,1 0,3
            int length = mat.length;
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][i];
                sum += mat[length - 1- i][i];
            }
            if((length & 1) == 1) {
                sum -= mat[length >> 1][length >> 1];
            }
            return sum;
        }
    }
}
