package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/5 6:41 下午
 */
public class Problem88 {

    public static void main(String[] args) {

    }


    private static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] result = new int[m + n];
            int index = 0;
            int i = 0, j = 0;
            for (; i < m && j < n; ) {
                if (nums1[i] < nums2[j]) {
                    result[index ++] = nums1[i++];
                }else if (nums1[i] > nums2[j]) {
                    result[index ++] = nums2[j++];
                }else {
                    result[index++] = nums1[i++];
                    result[index++] = nums2[j++];
                }
            }
            while (i < m) {
                result[index++] = nums1[i++];
            }
            while (j < n) {
                result[index++] = nums2[j++];
            }
            for (int k = 0; k < m + n; k++) {
                nums1[k] = result[k];

            }
        }
    }
}
