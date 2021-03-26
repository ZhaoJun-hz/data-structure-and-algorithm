package com.zj.study.leetcode;

/**
 * @author zj
 * @desiription:
 * @date 2021/3/25 6:19 下午
 */
public class Problem441_Method1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
        System.out.println(solution.arrangeCoins(2147483647));
    }

    private static class Solution {
        public int arrangeCoins(int n) {
            int sum = 0;
            int index = 1;
            while(true) {
                if(n - sum == index) {
                    return index;
                }else if (n - sum < index) {
                    return index - 1;
                }
                sum += index;
                index++;
            }
        }
    }
}
