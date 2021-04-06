package com.zj.study.leetcode.array;

import java.util.Arrays;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/running-sum-of-1d-array/</a>
 * <p>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 * @author zj
 * @desiription:
 * @date 2021/4/6 9:49 上午
 */
public class Problem1480 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.runningSum(nums)));

        nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution.runningSum(nums)));

        nums = new int[]{3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(solution.runningSum(nums)));
    }

    private static class Solution {
        public int[] runningSum(int[] nums) {
            int[] result = new int[nums.length];
            result[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] + nums[i];
            }
            return result;
        }
    }
}
