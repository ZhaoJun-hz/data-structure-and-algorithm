package com.zj.study.leetcode.array;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 10:54 上午
 */
public class Problem1470 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int n;

        nums = new int[]{2,5,1,3,4,7};
        n = 3;
        System.out.println(Arrays.toString(solution.shuffle(nums, n)));

    }

    private static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] result = new int[2 * n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                result[index ++] = nums[i];
                result[index ++] = nums[i + n];
            }
            return result;
        }
    }
}
