package com.zj.study.leetcode.array;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/14 11:14 下午
 */
public class Problem1464 {

    private static class Solution {
        public int maxProduct(int[] nums) {
            Arrays.sort(nums);
            return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
        }
    }
}
