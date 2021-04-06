package com.zj.study.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 1:32 下午
 */
public class Problem1313 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(solution.decompressRLElist(nums)));
    }

    private static class Solution {
        public int[] decompressRLElist(int[] nums) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; ) {
                int times = nums[i];
                int number = nums[i + 1];
                for (int j = 0; j < times; j++) {
                    result.add(number);
                }
                i += 2;
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

}
