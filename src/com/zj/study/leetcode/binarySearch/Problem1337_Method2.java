package com.zj.study.leetcode.binarySearch;

import java.util.Arrays;

public class Problem1337_Method2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] mat = {
        //         {1,1,0,0,0},
        //         {1,1,1,1,0},
        //         {1,0,0,0,0},
        //         {1,1,0,0,0},
        //         {1,1,1,1,1}
        // };
        // int k = 3;
        int[][] mat = {
                {1, 0},
                {0, 0},
                {1, 0}
        };
        int k = 2;
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, k)));
    }

    private static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int row = mat.length;
            int temp[][] = new int[row][2];
            for (int i = 0; i < row; i++) {
                temp[i][0] = i;
                temp[i][1] = searchBinary(mat[i]);
            }
            Arrays.sort(temp, (event1, event2) -> event1[1] == event2[1] ? event1[0] - event2[0] : event1[1] - event2[1]);
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = temp[i][0];
            }
            return result;
        }

        // 找到第一个不为0的数
        private int searchBinary(int[] nums) {
            int l = 0, r = nums.length - 1;
            int mid;
            int index = -1;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                if (nums[mid] == 1) {
                    index = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return index;
        }
    }
}
