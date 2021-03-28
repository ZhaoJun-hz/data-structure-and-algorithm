package com.zj.study.leetcode.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem349_Method2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            Set<Integer> resultSet = new HashSet<>();
            for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
                if (nums1[i] == nums2[j]) {
                    resultSet.add(nums1[i]);
                    i++;
                    j++;
                }else if(nums1[i] > nums2[j]) {
                    j++;
                }else if (nums1[i] < nums2[j]) {
                    i++;
                }
            }
            int[] result = new int[resultSet.size()];
            int index = 0;
            for (Integer num : resultSet) {
                result[index++] = num;
            }
            return result;
        }
    }
}
