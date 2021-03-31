package com.zj.study.leetcode.math;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/add-digits/</a>
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗
 * <p>
 * 思路: 数根
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 6:53 下午
 */
public class Problem258 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
    }

    private static class Solution {
        public int addDigits(int num) {
            return (num - 1) % 9 + 1;
        }
    }
}
