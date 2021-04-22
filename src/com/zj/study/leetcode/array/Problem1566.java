package com.zj.study.leetcode.array;

import com.zj.study.leetcode.content.Solution;

import java.util.Arrays;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/21 4:44 下午
 */
public class Problem1566 {

    public static void main(String[] args) {
        int[] arr;
        int m;
        int k;
        Solution solution = new Solution();
        arr = new int[]{2, 2};
        m = 1;
        k = 2;
        System.out.println(solution.containsPattern(arr, m, k)); // true

        arr = new int[]{1,2,4,4,4,4};
        m = 1;
        k = 3;
        System.out.println(solution.containsPattern(arr, m, k)); // true

        arr = new int[]{1,2,1,2,1,1,1,3};
        m = 2;
        k = 2;
        System.out.println(solution.containsPattern(arr, m, k)); // true

        arr = new int[]{1,2,1,2,1,3};
        m = 2;
        k = 3;
        System.out.println(solution.containsPattern(arr, m, k)); // false

        arr = new int[]{1,2,3,1,2};
        m = 2;
        k = 2;
        System.out.println(solution.containsPattern(arr, m, k)); // false

        arr = new int[]{2,2,2,2};
        m = 2;
        k = 3;
        System.out.println(solution.containsPattern(arr, m, k)); // false

        arr = new int[]{2,2,1,2,2,1,1,1,2,1};
        m = 2;
        k = 2;
        System.out.println(solution.containsPattern(arr, m, k)); // false
    }

    private static class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            if(m > arr.length) return false;
            if(m * k > arr.length) return false;
            for (int i = 0; i + m < arr.length; i++) {
                int temp = 1;
                int[] now = getElements(arr, i, m);
                for (int j = i + m; j + m <= arr.length; j += m) {
                    int[] search = getElements(arr, j, m);
                    if(compare(now, search)) {
                        temp ++;
                    }else {
                        break;
                    }
                    if(temp == k) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean compare(int[] now, int[] search) {
            for (int i = 0; i < now.length; i++) {
                if(now[i] != search[i]) {
                    return false;
                }
            }
            return true;
        }

        private int[] getElements(int[] arr, int index, int m) {
            int[] result = new int[m];
            for (int i = 0; i < m; i++) {
                result[i] = arr[index + i];
            }
            return result;
        }
    }

}
