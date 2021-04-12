package com.zj.study.leetcode.math;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/10 7:45 上午
 */
public class Problem263 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUgly(14));
        System.out.println(solution.isUgly(6));
        System.out.println(solution.isUgly(8));
    }

    private static class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            int temp = 0;
            while (n > 1) {
                if(n % 2 == 0) {
                    n /=2;
                    temp ++;
                }else if (n % 3 == 0) {
                    n /= 3;
                    temp ++;
                }else if (n % 5 == 0) {
                    n /= 5;
                    temp ++;
                }
                if (n > 1 && temp == 0) {
                    return false;
                }
                temp  = 0;
            }
            return true;
        }
    }
}
