package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/6 11:44 上午
 */
public class Problem1389 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int[] index;

        nums = new int[]{0, 1, 2, 3, 4};
        index = new int[]{0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(solution.createTargetArray(nums, index)));

    }

    private static class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < index.length; i++) {
                result.add(index[i], nums[i]);
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}
