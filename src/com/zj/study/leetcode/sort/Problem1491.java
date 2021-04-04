package com.zj.study.leetcode.sort;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/3 11:26 上午
 */
public class Problem1491 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] salary;
        salary = new int[]{4000,3000,1000,2000};
        System.out.println(solution.average(salary));
        salary = new int[]{1000,2000,3000};
        System.out.println(solution.average(salary));


    }

    private static class Solution {
        public double average(int[] salary) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : salary) {
                sum += num;
                if (num < min) {
                    min = num;
                }
                if(num > max) {
                    max = num;
                }
            }
            sum = sum - max - min;
            return sum * 1.0 / (salary.length - 2);
        }
    }
}
