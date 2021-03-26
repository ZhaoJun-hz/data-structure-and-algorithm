package com.zj.study.leetcode;

import java.util.Arrays;

/**
 * @author zj
 * @date 2021/3/25 1:54 下午
 */
public class Problem167_Method2 {

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
            for (int i = 0, j = numbers.length - 1; i < j;) {
                if(numbers[i] + numbers[j] == target) {
                    index1 = i;
                    index2 = j;
                    break;
                }else if (numbers[i] + numbers[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return new int[] {index1 + 1, index2 + 1};
        }
    }
}
