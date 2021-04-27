package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/27 9:21 上午
 */
public class Problem1011 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int shipWithinDays(int[] ws, int d) {
            int l = 1, r = (int)1e8;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if(check(ws, mid, d)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }

        boolean check(int[] ws, int t, int d) {
            if(ws[0] > t) return false;
            int n = ws.length;
            int cnt = 1;
            for (int i = 1, sum = ws[0]; i <n ; sum = 0, cnt++) {
                if(ws[i] > t)  return false;
                while (i < n && sum + ws[i] <= t) {
                    sum += ws[i];
                    i++;
                }
            }
            return cnt - 1 <= d;
        }
    }
}
