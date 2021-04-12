package com.zj.study.leetcode.twoPointers;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/9 11:39 上午
 */
public class Problem1800 {
    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        // nums = new int[]{10,20,30,5,10,50};
        // System.out.println(solution.maxAscendingSum(nums)); // 65

        // nums = new int[]{10,20,30,40,50};
        // System.out.println(solution.maxAscendingSum(nums)); // 150

        nums = new int[]{12,17,15,13,10,11,12};
        System.out.println(solution.maxAscendingSum(nums)); // 33
    }

    private static class Solution {
        public int maxAscendingSum(int[] nums) {
            int max = Integer.MIN_VALUE;
            int tempSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] > nums[i - 1]) {
                    tempSum += nums[i];
                }else {
                    if(tempSum > max) {
                        max = tempSum;
                    }
                    tempSum = nums[i];
                }
            }
            if (tempSum > max) {
                max = tempSum;
            }
            return max;
        }
    }
}
