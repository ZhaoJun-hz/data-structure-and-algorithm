package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 11:05 上午
 */
public class Problem70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
    }

    private static class Solution {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            int a = 1, b = 2, c;
            for (int i = 2; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }
}
