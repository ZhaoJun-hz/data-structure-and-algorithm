package com.zj.study.leetcode.array;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/19 9:36 上午
 */
public class Problem978 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;

        arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(solution.maxTurbulenceSize(arr)); // 5
        arr = new int[]{4, 8, 12, 16};
        System.out.println(solution.maxTurbulenceSize(arr)); // 2
        arr = new int[]{100};
        System.out.println(solution.maxTurbulenceSize(arr)); // 1
        arr = new int[]{9, 9};
        System.out.println(solution.maxTurbulenceSize(arr)); // 1
        arr = new int[]{8, 8, 9, 10, 6, 8, 2, 4, 2, 2, 10, 6, 6, 10, 10, 2, 3, 5, 1, 2, 10, 4, 2, 0, 9, 4, 9, 3, 0, 6, 3, 2, 3, 10, 10, 6, 4, 6, 4, 4, 2, 5, 1, 4, 1, 1, 9, 8, 9, 5, 3, 5, 5, 4, 5, 5, 6, 5, 3, 3, 7, 2, 0, 10, 9, 7, 7, 3, 5, 1, 0, 9, 6, 3, 1, 3, 4, 4, 3, 6, 3, 2, 1, 4, 10, 2, 3, 4, 4, 3, 6, 7, 6, 2, 1, 7, 0, 6, 8, 10};
        System.out.println(solution.maxTurbulenceSize(arr));// 7
        arr = new int[]{0,8,45,88,48,68,28,55,17,24};
        System.out.println(solution.maxTurbulenceSize(arr)); // 8
    }

    private static class Solution {
        public int maxTurbulenceSize(int[] arr) {
            if (arr.length == 1) return 1;
            int[] temp = new int[arr.length - 1];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    temp[i - 1] = 0;
                } else if (arr[i] < arr[i - 1]) {
                    temp[i - 1] = 1;
                } else {
                    temp[i - 1] = -1;
                }
            }
            int result = -1;
            int tempLength = 1;
            int prev = -1;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == -1) {
                    if (tempLength > result) {
                        result = tempLength;
                    }
                    prev = -1;
                    tempLength = 1;
                } else {
                    if (tempLength == 1) {
                        tempLength++;
                        prev = temp[i];
                    } else {
                        if (prev != temp[i]) {
                            tempLength++;
                            prev = temp[i];
                        } else {
                            if (tempLength > result) {
                                result = tempLength;
                            }
                            tempLength = 2;
                            prev = temp[i];
                        }
                    }
                }
            }
            if (tempLength > result) {
                result = tempLength;
            }
            return result;
        }
    }
}
