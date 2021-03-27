package com.zj.study.leetcode;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/power-of-two/</a>
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 思路: 位运算, x & (x - 1) 把最低位的1去掉, 如果为0.则
 * @author zj
 * @desiription:
 * @date 2021/3/26 4:53 下午
 */
public class Problem231_Method2 {

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
            return (n & (n - 1)) == 0;
        }
    }
}
