package com.zj.study.leetcode.binarySearch;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/sqrtx/</a>
 * <p>
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 思路: 二分
 */
public class Problem69 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.mySqrt(0));
        // System.out.println(solution.mySqrt(8));
        // System.out.println(solution.mySqrt(9));
        // System.out.println(solution.mySqrt(15));
        // System.out.println(solution.mySqrt(16));
        // System.out.println(solution.mySqrt(17));
        System.out.println(solution.mySqrt(2147395599));

    }

    private static class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    // 乘积, 即平方, 小于等于x, 记录下来这个位置, 左指针右移
                    ans = mid;
                    l = mid + 1;
                } else {
                    // 乘积, 即平方, 大于x, 右指针左移
                    r = mid - 1;
                }
            }
            // 返回记录下来的值
            return ans;
        }
    }
}
