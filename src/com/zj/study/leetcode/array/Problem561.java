package com.zj.study.leetcode.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 6:02 下午
 */
public class Problem561 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{1,4,3,2};
        System.out.println(solution.arrayPairSum(nums));
        nums = new int[]{6,2,6,5,1,2};
        System.out.println(solution.arrayPairSum(nums));
    }

    private static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int result = 0;
            for (int i = nums.length - 2; i >= 0; i-=2) {
                result += nums[i];
            }
            return result;
        }
    }
}
