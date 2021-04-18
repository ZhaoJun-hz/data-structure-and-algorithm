package com.zj.study.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/17 9:37 上午
 */
public class Problem217_Method1 {

    public static void main(String[] args) {
        int[] nums;
        Solution solution = new Solution();
        nums = new int[]{1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums));
        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(solution.containsDuplicate(nums));

    }

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> numMap = new HashMap<>();
            for (int num : nums) {
                numMap.put(num, numMap.getOrDefault(num, 0) + 1);
                Integer times = numMap.get(num);
                if (times > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
