package com.zj.study.leetcode;

import java.util.Arrays;

public class Problem1337_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k = 3;
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, k)));
    }

    private static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int row = mat.length;
            int col = mat[0].length;
            int temp[][] = new int[row][2];
            for(int i = 0; i < row; i++) {
                temp[i][0] = i;
                for(int j = 0; j < col; j++) {
                    if (mat[i][j] == 1) {
                        temp[i][1] += 1;
                    }
                }
            }
            Arrays.sort(temp, (event1, event2) -> event1[1] == event2[1] ? event1[0] - event2[0] : event1[1] - event2[1]);
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = temp[i][0];
            }
            return result;
        }
    }
}
