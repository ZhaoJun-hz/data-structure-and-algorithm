package com.zj.study.leetcode;

/**
 * @author zj
 * @desiription:
 * @date 2021/3/25 6:19 下午
 */
public class Problem441_Method2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
        System.out.println(solution.arrangeCoins(2147483647));
    }

    private static class Solution {
        public int arrangeCoins(int n) {
            int l = 1, r = n;
            long mid, sum;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                sum = (mid * (mid + 1)) >> 1;
                if (sum == n) {
                    return (int) mid;
                }else if (sum < n) {
                    l = (int) (mid + 1);
                }else if (sum > n) {
                    r = (int) (mid - 1);
                }
            }
            return r;
        }
    }
}
