package com.zj.study.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目链接: <a>https://leetcode-cn.com/problems/self-dividing-numbers/</a>
 * <p>
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 * <p>
 * 思路: 数学
 *
 * @author zj
 * @desiription:
 * @date 2021/3/30 10:56 上午
 */
public class Problem728 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.selfDividingNumbers(1, 22));
    }

    private static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> result = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                if (judgeSelfDividing(i)) {
                    result.add(i);
                }
            }
            return result;
        }

        private boolean judgeSelfDividing(int number) {
            int temp = number;
            while (temp > 0) {
                int a = temp % 10;
                if (a == 0) return false;
                if (number % a != 0) return false;
                temp /= 10;
            }

            return true;
        }
    }
}
