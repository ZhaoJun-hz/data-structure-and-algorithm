package com.zj.study.leetcode.math;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/maximum-69-number/</a>
 * <p>
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * 请返回你可以得到的最大数字。
 * 1 <= num <= 10^4
 * num 每一位上的数字都是 6 或者 9 。
 * <p>
 * 思路: 数学
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 10:10 上午
 */
public class Problem1323 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximum69Number(69));
        System.out.println(solution.maximum69Number(99));
        System.out.println(solution.maximum69Number(699));
        System.out.println(solution.maximum69Number(669));
        System.out.println(solution.maximum69Number(969));
        System.out.println(solution.maximum69Number(966));
        System.out.println(solution.maximum69Number(9999));
        System.out.println(solution.maximum69Number(6666));
    }

    private static class Solution {
        public int maximum69Number(int num) {
            if (num == 9 || num == 6) return 9;
            int div = 1;
            int mul = 10;
            if (num > 10 && num < 100) {
                div = 10;
            } else if (num > 100 && num < 1000) {
                div = 100;
            } else if (num > 1000) {
                div = 1000;
            }
            int result = 0;
            while (num > 0) {
                int a = num / div;
                int b = num % div;
                if (a == 6) {
                    result = result * mul + 9;
                    return result * div + b;
                } else {
                    result = result * mul + 9;
                }
                num = b;
                div /= 10;
            }
            return result;
        }
    }
}
