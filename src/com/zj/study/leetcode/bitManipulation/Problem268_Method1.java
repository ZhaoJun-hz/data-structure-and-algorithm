package com.zj.study.leetcode.bitManipulation;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/missing-number/</a>
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 思路: 求和
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 11:24 上午
 */
public class Problem268_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        nums = new int[]{3,0,1};
        System.out.println(solution.missingNumber(nums));
    }

    private static class Solution {
        public int missingNumber(int[] nums) {
            int length = nums.length;
            int sum = (length * (length + 1)) >> 1;
            for (int i = 0; i < nums.length; i++) {
                sum -= nums[i];
            }
            return sum;
        }
    }
}
