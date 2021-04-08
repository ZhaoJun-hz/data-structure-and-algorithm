package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/7 8:10 上午
 */
public class Problem1732 {
    public static void main(String[] args) {
        int[] gain;
        Solution solution = new Solution();
        gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(solution.largestAltitude(gain));

        gain = new int[]{-4,-3,-2,-1,4,3,2};
        System.out.println(solution.largestAltitude(gain));
    }

    private static class Solution {
        public int largestAltitude(int[] gain) {
            int max = 0;
            int sum = 0;
            for (int num : gain) {
                sum += num;
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }
    }
}
