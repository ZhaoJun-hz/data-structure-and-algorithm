package com.zj.study.leetcode.bitManipulation;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/</a>
 * <p>
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * @author zj
 * @desiription:
 * @date 2021/3/29 5:56 下午
 */
public class Problem762 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimeSetBits(6, 10));
        System.out.println(solution.countPrimeSetBits(10, 15));
    }

    private static class Solution {
        public int countPrimeSetBits(int L, int R) {
            int result = 0;
            for (int i = L; i <= R; i++) {
                if (isPrime(Integer.bitCount(i))) {
                    result++;
                }
            }
            return result;
        }

        private boolean isPrime(int num) {
            if (num == 1) {
                return false;
            }
            if (num == 2 || num == 3) {
                return true;
            }
            if (num % 6 != 1 && num % 6 != 5) {
                return false;
            }

            int tmp = (int) Math.sqrt(num);//获取平方根
            //在6的倍数两侧的也可能不是素数
            for (int i = 5; i <= tmp; i += 6) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
