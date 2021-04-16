package com.zj.study.leetcode.dynamicProgramming;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 11:33 上午
 */
public class Problem303 {

    public static void main(String[] args) {
        int [] nums;
        NumArray numArray;
        nums = new int[]{-2, 0, 3, -5, 2, -1};
        numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange( 2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    private static class NumArray {

        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }
}
