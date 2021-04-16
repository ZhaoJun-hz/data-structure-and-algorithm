package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 12:05 下午
 */
public class Problem724_Method2 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{2, 1, -1};
        System.out.println(solution.pivotIndex(nums)); // 0

        nums = new int[]{1, 2, 3};
        System.out.println(solution.pivotIndex(nums)); // -1

        nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(solution.pivotIndex(nums)); // 3

        nums = new int[]{-1, -1, 0, 1, 1, 0};
        System.out.println(solution.pivotIndex(nums)); // 5
    }

    private static class Solution {
        public int pivotIndex(int[] nums) {
            // index 0 1 2 3 4  5  6  7  8
            // nums  2 3 4 5 6  7  8  9  10
            // sums  0 2 5 9 14 20 27 35 44 54
            int[] sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            int sum1, sum2;
            for (int i = 0; i < nums.length; i++) {
                sum1 = sums[i];
                sum2 = sums[nums.length] - sums[i + 1];
                if (sum1 == sum2) {
                    return i;
                }
            }
            return -1;
        }
    }
}
