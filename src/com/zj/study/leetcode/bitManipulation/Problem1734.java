package com.zj.study.leetcode.bitManipulation;

/**
 * @author zj
 * @desiription:
 * @date 2021/5/11 6:33 上午
 */
public class Problem1734 {

    public static void main(String[] args) {
        int[] encoded;
        encoded = new int[]{1,2,3,4,5};
        for (int i = 0; i < encoded.length - 1; i++) {
            for (int j = i + 1; j < encoded.length; j++) {
                System.out.println(encoded[i] ^ encoded[j]);
            }

        }
    }

    private static class Solution {
        public int[] decode(int[] encoded) {
            return new int[]{};
        }
    }
}
