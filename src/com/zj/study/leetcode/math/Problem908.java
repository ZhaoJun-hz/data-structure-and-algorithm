package com.zj.study.leetcode.math;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/smallest-range-i/</a>
 *
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 4:30 下午
 */
public class Problem908 {

    public static void main(String[] args) {
        int K;
        int[] A;
        Solution solution = new Solution();

        A = new int[]{1};
        K = 0;
        System.out.println(solution.smallestRangeI(A, K));

        A = new int[]{0,10};
        K = 2;
        System.out.println(solution.smallestRangeI(A, K));

        A = new int[]{1, 3, 6};
        K = 3;
        System.out.println(solution.smallestRangeI(A, K));
    }

    private static class Solution {
        public int smallestRangeI(int[] A, int K) {
            int min = 10001, max = -1;
            for(int num : A) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
            if (max - min < K * 2) {
                return 0;
            } else {
                return max - K - (min + K);
            }
        }
    }
}
