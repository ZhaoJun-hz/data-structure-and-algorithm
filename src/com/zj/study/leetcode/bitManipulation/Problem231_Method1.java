package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/power-of-two/</a>
 * <p>
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 思路: 一直整除2
 *
 * @author zj
 * @desiription:
 * @date 2021/3/26 4:53 下午
 */
public class Problem231_Method1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(-16));
        System.out.println(solution.isPowerOfTwo(218));
    }

    private static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }

            while (n > 0) {
                if (n == 1) {
                    return true;
                }
                if (n % 2 != 0) {
                    return false;
                }
                n /= 2;
            }
            return true;
        }
    }
}
