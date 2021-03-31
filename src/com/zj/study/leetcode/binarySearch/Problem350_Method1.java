package com.zj.study.leetcode.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/</a>
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 思路: 使用Map保存数组中, 数字出现的次数
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Problem350_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));
    }

    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                int times = map.getOrDefault(num, 0) + 1;
                map.put(num, times);
            }

            int[] result = new int[nums1.length];
            int index = 0;
            for (int num : nums2) {
                Integer times = map.getOrDefault(num, 0);
                if (times > 0) {
                    result[index++] = num;
                }
                times--;
                if (times > 0) {
                    map.put(num, times);
                } else {
                    map.remove(num);
                }
            }
            return Arrays.copyOfRange(result, 0, index);
        }
    }
}
