package com.zj.study.leetcode.binarySearch;


public class Problem852 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] arr = {3, 5, 3, 2, 0};
        int[] arr = {3, 4, 5, 1};
        System.out.println(solution.peakIndexInMountainArray(arr));
    }

    private static class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] < arr[mid - 1]) {
                    r = mid;
                } else if (arr[mid] < arr[mid + 1]) {
                    l = mid;
                }
            }
            return -1;
        }
    }
}
