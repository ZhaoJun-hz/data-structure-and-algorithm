package com.zj.study.leetcode;

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

    // private static class Solution {
    //     public int mySqrt(int x) {
    //         int l = 1, r = x / 2 + 1;
    //         int mid ;
    //         while (l <= r) {
    //             mid = l + ((r - l) >> 1);
    //             long temp1 = (long) mid * mid;
    //             long temp2 = (long) (mid - 1) * (mid - 1);
    //             if (temp1 == x) {
    //                 return mid;
    //             }else if (temp1 > x && temp2 <= x) {
    //                 return mid - 1;
    //             }else if (temp1 < x) {
    //                 l = mid + 1;
    //             }else if (temp1 > x && temp2 > x) {
    //                 r = mid - 1;
    //             }
    //         }
    //         return 0;
    //     }
    // }

    private static class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }
}
