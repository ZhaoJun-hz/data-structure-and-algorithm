package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 10:45 上午
 */
public class Problem1672 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] accounts;

        accounts = new int[][]{{1, 2, 3}, {3, 2, 1}};
        System.out.println(solution.maximumWealth(accounts));

        accounts = new int[][]{{1, 5}, {7, 3}, {3, 5}};
        System.out.println(solution.maximumWealth(accounts));

        accounts = new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(solution.maximumWealth(accounts));
    }

    private static class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = Integer.MIN_VALUE;
            int row = accounts.length;
            int col = accounts[0].length;

            for (int i = 0; i < row; i++) {
                int temp = 0;
                for (int j = 0; j < col; j++) {
                    temp += accounts[i][j];
                }
                if (temp > max) {
                    max = temp;
                }
            }
            return max;
        }
    }
}
