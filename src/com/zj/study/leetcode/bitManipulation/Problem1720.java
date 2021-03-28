package com.zj.study.leetcode.bitManipulation;

import java.util.Arrays;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/decode-xored-array/</a>
 * <p>
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * 思路: a ^ b = c  --> b ^ c = a
 *
 * @author zj
 * @desiription:
 * @date 2021/3/27 4:34 下午
 */
public class Problem1720 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] encoded;
        int first;

        // encoded = new int[]{1, 2, 3};
        // first = 1;
        // System.out.println(Arrays.toString(solution.decode(encoded, first)));

        encoded = new int[]{6, 2, 7, 3};
        first = 4;
        System.out.println(Arrays.toString(solution.decode(encoded, first)));

    }


    private static class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] result = new int[encoded.length + 1];
            result[0] = first;
            // for (int i = 0; i < encoded.length; i++) {
            //     result[i + 1] = result[i] ^ encoded[i];
            // }
            for (int i = 1; i <= encoded.length; i++) {
                result[i] = result[i - 1] ^ encoded[i - 1];
            }
            return result;
        }
    }
}
