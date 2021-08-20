package com.zj.study.leetcode.math;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/28 12:57 下午
 */
public class Problem633 {

   private static class Solution {
        public boolean judgeSquareSum(int c) {
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a * a);
                if (b == (int) b) {
                    return true;
                }
            }
            return false;
        }
    }
}
