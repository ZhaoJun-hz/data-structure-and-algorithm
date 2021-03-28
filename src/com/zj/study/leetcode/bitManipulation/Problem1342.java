package com.zj.study.leetcode.bitManipulation;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/</a>
 *
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 * 思路: 位运算
 * @author zj
 * @desiription:
 * @date 2021/3/27 4:10 下午
 */
public class Problem1342 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
        System.out.println(solution.numberOfSteps(8));
        System.out.println(solution.numberOfSteps(123));
    }

    private static class Solution {
        public int numberOfSteps (int num) {
            int step = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    num = num - 1;
                } else {
                    num = num >> 1;
                }
                step ++;
            }
            return step;
        }
    }
}
