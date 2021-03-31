package com.zj.study.leetcode.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/intersection-of-two-arrays/</a>
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 思路: 一个数组排序,二分查找
 */
public class Problem349_Method3 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> resultSet = new HashSet<>();
            Arrays.sort(nums2);
            for (int num : nums1) {
                if (!resultSet.contains(num)) {
                    if (binarySearch(nums2, num)) {
                        resultSet.add(num);
                    }
                }
            }
            int[] result = new int[resultSet.size()];
            int index = 0;
            for (Integer num : resultSet) {
                result[index++] = num;
            }
            return result;
        }

        private boolean binarySearch(int[] num, int target) {
            int l = 0, r = num.length - 1;
            int mid;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (num[mid] == target) {
                    return true;
                } else if (num[mid] > target) {
                    r = mid - 1;
                } else if (num[mid] < target) {
                    l = mid + 1;
                }
            }
            return false;
        }
    }
}
