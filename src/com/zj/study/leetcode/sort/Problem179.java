package com.zj.study.leetcode.sort;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/12 10:22 上午
 */
public class Problem179 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();

        nums = new int[]{10, 2};
        System.out.println(solution.largestNumber(nums));

        nums = new int[] {3,30,34,5,9};
        System.out.println(solution.largestNumber(nums));

        nums = new int[]{1};
        System.out.println(solution.largestNumber(nums));

        nums = new int[] {10};
        System.out.println(solution.largestNumber(nums));
        nums = new int[] {3, 33, 333};
        System.out.println(solution.largestNumber(nums));
        nums = new int[] {3, 33, 333, 3334};
        System.out.println(solution.largestNumber(nums));
        nums = new int[] {3,33,333,3332};
        System.out.println(solution.largestNumber(nums));
        nums = new int[] {111311, 1113};
        System.out.println(solution.largestNumber(nums));
        nums = new int[] {3,31};
        System.out.println(solution.largestNumber(nums));

    }

    private static class Solution {
        public String largestNumber(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - 1 - i; j++) {
                    if (compare(nums[j], nums[j + 1])) {
                        nums[j] = nums[j] ^ nums[j + 1];
                        nums[j + 1] = nums[j] ^ nums[j + 1];
                        nums[j] = nums[j] ^ nums[j + 1];
                    }
                }
            }
            if (nums[0] == 0) return "0";
            // System.out.println(Arrays.toString(nums));
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                result.append(nums[i]);
            }
            return result.toString();
        }

        private boolean compare(int a, int b) {
            String aString = String.valueOf(a);
            String bString = String.valueOf(b);
            return (aString + bString).compareTo(bString + aString) < 0;
        }
    }
}
