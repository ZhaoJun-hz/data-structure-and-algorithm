package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 4:57 下午
 */
public class Problem153_Method1 {

    public static void main(String[] args) {

    }

    class Solution {
        public int findMin(int[] nums) {
            int result = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < result) {
                    result = num;
                }
            }
            return result;
        }
    }
}
