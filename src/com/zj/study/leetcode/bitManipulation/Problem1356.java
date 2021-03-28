package com.zj.study.leetcode.bitManipulation;

import java.util.Arrays;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/</a>
 *
 * 给你一个整数数组 arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 *
 * 思路:x & (x - 1)消除最后一位1 判断是不是0 获取二进制1的个数, 然后排序
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 5:34 下午
 */
public class Problem1356 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(solution.sortByBits(arr)));
        arr = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println(Arrays.toString(solution.sortByBits(arr)));
        arr = new int[]{10000, 10000};
        System.out.println(Arrays.toString(solution.sortByBits(arr)));
        arr = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(Arrays.toString(solution.sortByBits(arr)));
        arr = new int[]{10,100,1000,10000};
        System.out.println(Arrays.toString(solution.sortByBits(arr)));
    }

    private static class Solution {
        public int[] sortByBits(int[] arr) {
            int[][] temp = new int[arr.length][2];
            for (int i = 0; i < arr.length; i++) {
                temp[i][0] = arr[i];
                temp[i][1] = getOneNumber(arr[i]);
            }
            Arrays.sort(temp, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = temp[i][0];
            }
            return result;
        }

        private int getOneNumber(int num) {
            int index = 0;
            while (num != 0) {
                num &= num - 1;
                index++;
            }
            return index;
        }
    }
}
