package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/3 10:57 上午
 */
public class Problem1143 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1,text2;
        text1 = "abcde";
        text2 = "ace";
        System.out.println(solution.longestCommonSubsequence(text1, text2));

        text1 = "abc";
        text2 = "abc";
        System.out.println(solution.longestCommonSubsequence(text1, text2));

        text1 = "abc"; text2 = "def";
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }

    private static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j -  1] + 1;
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
