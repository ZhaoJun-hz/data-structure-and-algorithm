package com.zj.study.leetcode.binarySearch;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/first-bad-version/</a>
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 思路: 二分
 *
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
