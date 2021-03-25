package com.zj.study.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem349_Method1 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();
            for (int num : nums1) {
                setA.add(num);
            }
            for (int num : nums2) {
                setB.add(num);
            }

            Set<Integer> setC = new HashSet<>();
            for(Integer num : setA) {
                if (setB.contains(num)) {
                    setC.add(num);
                }
            }
            int[] result = new int[setC.size()];
            int index = 0;
            for(Integer num : setC) {
                result[index++] = num;
            }
            return result;
        }
    }
}
