package com.zj.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem350_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));
    }

    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                int times = map.getOrDefault(num, 0) + 1;
                map.put(num, times);
            }

            int[] result = new int[nums1.length];
            int index = 0;
            for (int num : nums2) {
                Integer times = map.getOrDefault(num, 0);
                if(times > 0) {
                    result[index ++] = num;
                }
                times--;
                if (times > 0) {
                    map.put(num, times);
                } else {
                    map.remove(num);
                }
            }
            return Arrays.copyOfRange(result, 0, index);
        }
    }
}
