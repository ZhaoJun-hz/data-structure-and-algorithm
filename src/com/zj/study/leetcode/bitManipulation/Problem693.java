package com.zj.study.leetcode.bitManipulation;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/binary-number-with-alternating-bits/</a>
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 * 思路: 异或
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 2:29 下午
 */
public class Problem693 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));
        System.out.println(solution.hasAlternatingBits(3));
    }

    private static class Solution {
        public boolean hasAlternatingBits(int n) {
            int position = 0;
            if ((n & 1) == 1) {
              position = 1;
            }
            n = n >> 1;
            while(n != 0) {
                int temp = n & 1;
                if(temp == position) {
                    return false;
                }
                n = n >> 1;
                position = temp;
            }
            return true;
        }
    }
}
