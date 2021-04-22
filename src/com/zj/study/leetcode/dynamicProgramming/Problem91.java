package com.zj.study.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/21 11:40 上午
 */
public class Problem91 {

    public static void main(String[] args) {
        String s;
        Solution solution = new Solution();
        s = "12";
        System.out.println(solution.numDecodings(s));// 2

        s = "226";
        System.out.println(solution.numDecodings(s));// 3
        s = "2101";
        System.out.println(solution.numDecodings(s));// 1
        s = "1123";
        System.out.println(solution.numDecodings(s));// 4
        s = "0";
        System.out.println(solution.numDecodings(s));// 0
        s = "06";
        System.out.println(solution.numDecodings(s));// 0
    }

    private static class Solution {
        public int numDecodings(String s) {
            int length = s.length();
            int[] dp = new int[length + 1];
            dp[0] = 1;
            for (int i = 1; i <= length; i++) {
                if(s.charAt(i - 1) != '0'){
                    dp[i] += dp[i - 1];
                }
                if(i > 1 && s.charAt(i - 2) != '0' ){
                    int temp = 10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0');
                    if (temp > 9 && temp < 27) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[length];
        }
    }
}
