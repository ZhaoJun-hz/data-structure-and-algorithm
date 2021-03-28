package com.zj.study.leetcode.binarySearch;

/**
 * @author zj
 * @desiription:
 * @date 2021/3/25 7:21 下午
 */
public class Problem278 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(5));
    }

    private static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 1, r = n;
            int mid = -1;
            int index = n;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                boolean flag = isBadVersion(mid);
                if (flag) {
                    if (mid <= index) {
                        index = mid;
                    }
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return index;
        }
    }

    private static class VersionControl {
        int version = 4;

        boolean isBadVersion(int mid) {
            return mid == version;
        }
    }
}
