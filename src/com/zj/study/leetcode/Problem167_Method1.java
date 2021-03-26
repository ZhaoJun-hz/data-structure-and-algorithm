package com.zj.study.leetcode;

import java.util.Arrays;

/**
 * @author zj
 * @date 2021/3/25 1:54 下午
 */
public class Problem167_Method1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] numbers = {2,7,11,15};
        // int target = 9;

        // int[] numbers = {2,3,4};
        // int target = 6;

        // int[] numbers = {-1,0};
        // int target = -1;

        // int[] numbers = {5, 25, 75};
        // int target = 100;

        int[] numbers = {1,2,3,4,4,9,56,90};
        int target = 8;
        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int index1 = -1, index2 = -1;
            for (int i = 0; i < numbers.length; i++) {
                index1 = i;
                index2 = binarySearch(numbers, i, target);
                if (index1 != index2 && index2 > 0) {
                    break;
                }
            }
            return new int[] {index1 + 1, index2 + 1};
        }

        private int binarySearch(int[] numbers, int index, int result) {
            int target = result - numbers[index];
            int l = index + 1, r = numbers.length - 1;
            int mid = -1;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (numbers[mid] == target) {
                    return mid;
                }else if (numbers[mid] > target) {
                    r = mid - 1;
                }else if (numbers[mid] < target) {
                    l = mid + 1;
                }
            }
            return 0;
        }
    }
}
