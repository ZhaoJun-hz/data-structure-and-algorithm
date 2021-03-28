package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/3/26 9:33 上午
 */
public class Problem367 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.isPerfectSquare(14));
        // System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(2147483647));
    }

    private static class Solution {
        public boolean isPerfectSquare(int num) {
            int l = 1, r = num;
            int mid;
            long sum;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                sum = (long) mid * mid;
                if (sum == num) {
                    return true;
                } else if (sum > num) {
                    r = mid - 1;
                } else if (sum < num) {
                    l = mid + 1;
                }
            }
            return false;
        }
    }
}
