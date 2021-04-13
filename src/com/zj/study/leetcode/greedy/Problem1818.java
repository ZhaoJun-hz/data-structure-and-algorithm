package com.zj.study.leetcode.greedy;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/12 2:22 下午
 */
public class Problem1818 {

    public static void main(String[] args) {
        int[] nums1;
        int[] nums2;
        Solution solution = new Solution();

        // nums1 = new int[]{1, 7, 5};
        // nums2 = new int[]{2, 3, 5};
        // System.out.println(solution.minAbsoluteSumDiff(nums1, nums2));

        // nums1 = new int[]{2, 4, 6, 8, 10};
        // nums2 = new int[]{2, 4, 6, 8, 10};
        // System.out.println(solution.minAbsoluteSumDiff(nums1, nums2));

        // nums1 = new int[]{1,10,4,4,2,7};
        // nums2 = new int[]{9,3,5,1,7,4};
        // System.out.println(solution.minAbsoluteSumDiff(nums1, nums2));

        nums1 = new int[]{57,42,21,28,30,25,22,12,55,3,47,18,43,29,20,44,59,9,43,7,8,5,42,53,99,34,37,88,87,62,38,68,31,3,11,61,93,34,63,27,20,48,38,5,71,100,88,54,52,15,98,59,74,26,81,38,11,44,25,69,79,81,51,85,59,84,83,99,31,47,31,23,83,70,82,79,86,31,50,17,11,100,55,15,98,11,90,16,46,89,34,33,57,53,82,34,25,70,5,1};
        nums2 = new int[]{76,3,5,29,18,53,55,79,30,33,87,3,56,93,40,80,9,91,71,38,35,78,32,58,77,41,63,5,21,67,21,84,52,80,65,38,62,99,80,13,59,94,21,61,43,82,29,97,31,24,95,52,90,92,37,26,65,89,90,32,27,3,42,47,93,25,14,5,39,85,89,7,74,38,12,46,40,25,51,2,19,8,21,62,58,29,32,77,62,9,74,98,10,55,25,62,48,48,24,21};
        System.out.println(solution.minAbsoluteSumDiff(nums1, nums2));
    }

    private static class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            long sum = 0;
            for (int i = 0; i < nums1.length; i++) {
                sum += Math.abs(nums2[i] - nums1[i]);
            }
            int[] temp = new int[nums1.length];
            System.arraycopy(nums1, 0, temp, 0, nums1.length);
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
            long result = Long.MAX_VALUE;
            for (int i = 0; i < nums2.length; i++) {
                int searchIndex = binarySearch(temp, nums2[i]);
                result = Math.min(result, sum-Math.abs(nums1[i]-nums2[i]) + Math.abs(temp[searchIndex]-nums2[i]));
                System.out.println("searchIndex = " + searchIndex + ", temp[searchIndex] = " + temp[searchIndex] + ", nums2[i] = " + nums2[i] + ", result = " + result);
            }
            return (int)(result % 1000000007);
        }

        private int binarySearch(int[] nums, int temp) {
            int l = 0, r = nums.length - 1, mid;
            while (l < r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] >= temp) {
                    // 大于
                    r = mid;
                }else if (nums[mid] < temp) {
                    // 小于
                    l = mid + 1;
                }
            }
            if (l == 0) return 0;
            return Math.abs(nums[l]-temp) < Math.abs(nums[l-1]-temp) ? l : (l-1);
        }
    }
}
