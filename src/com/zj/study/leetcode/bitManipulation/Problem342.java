package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a></a>
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 * <p>
 * 思路:
 *
 * @author zj
 * @desiription:
 * @date 2021/3/28 6:51 下午
 */
public class Problem342 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(16));
        System.out.println(solution.isPowerOfFour(5));
        System.out.println(solution.isPowerOfFour(4));
        System.out.println(solution.isPowerOfFour(1));
        System.out.println(solution.isPowerOfFour(8));
    }

    private static class Solution {
        public boolean isPowerOfFour(int n) {
            if (n <= 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }

            if ((n & (n - 1)) != 0) {
                return false;
            }

            return (n % 3) == 1;
        }
    }
}
