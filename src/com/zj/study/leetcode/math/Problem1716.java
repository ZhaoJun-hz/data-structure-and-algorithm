package com.zj.study.leetcode.math;

/**
 *
 * 题目链接: <a>https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/</a>
 *
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 * @author zj
 * @desiription:
 * @date 2021/3/31 11:56 上午
 */
public class Problem1716 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }

    private static class Solution {
        public int totalMoney(int n) {
            int temp = 0;
            int tempNum = 1;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 7 == 1) {
                    temp ++;
                    tempNum = temp;
                }
                sum += tempNum;
                tempNum ++;
            }
            return sum;
        }
    }
}
