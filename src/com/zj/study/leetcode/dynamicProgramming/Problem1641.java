package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/23 9:58 下午
 */
public class Problem1641 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelStrings(1));
        System.out.println(solution.countVowelStrings(2));
        System.out.println(solution.countVowelStrings(33));
    }

    private static class Solution {
        public int countVowelStrings(int n) {
            if(n == 1) return 5;
            int[][] temp = new int[n][5];
            temp[0][0] = 0;
            temp[0][1] = 0;
            temp[0][2] = 0;
            temp[0][3] = 0;
            temp[0][4] = 0;
            for (int i = 1; i < n ; i++) {
                for (int j = 0; j < 5; j++) {
                    if(j == 0) {
                        temp[i][j] = 1;
                    }else {
                        temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
                    }
                }
            }
            int result = 5 * temp[n - 1][0] + 4 * temp[n - 1][1] + 3 * temp[n - 1][2] + 2 * temp[n - 1][3] +  temp[n - 1][4];
            return result;
        }
    }
}
