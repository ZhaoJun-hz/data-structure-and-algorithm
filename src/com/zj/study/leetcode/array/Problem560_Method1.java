package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/15 11:52 上午
 */
public class Problem560_Method1 {

    public static void main(String[] args) {
        int[] nums;
        int k;
        Solution solution = new Solution();
        nums = new int[]{1,1,1};
        k = 2;
        System.out.println(solution.subarraySum(nums, k));

        nums = new int[]{1,2,3};
        k = 3;
        System.out.println(solution.subarraySum(nums, k));
    }

    private static class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (sums[j + 1] - sums[i] == k) {
                        result ++;
                    }
                }
            }
            return result;
        }
    }
}
