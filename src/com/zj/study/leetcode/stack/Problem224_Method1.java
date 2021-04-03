package com.zj.study.leetcode.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/1 6:41 下午
 */
public class Problem224_Method1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1 + 1")); // 2
        System.out.println(solution.calculate(" 2-1 + 2 ")); // 3
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)")); // 23
        System.out.println(solution.calculate("-2+ 1")); // -1
        System.out.println(solution.calculate(" 2-1 + 2 ")); // 3
        System.out.println(solution.calculate("- (3 + (4 + 5))")); // -12
        System.out.println(solution.calculate("1-(+1+1)")); // -1
        System.out.println(solution.calculate("(7)-(0) + (4)")); // 11
    }

    private static class Solution {
        public int calculate(String s) {
            Deque<Integer> ops = new LinkedList<Integer>();
            ops.push(1);
            int sign = 1;

            int ret = 0;
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                } else if (s.charAt(i) == '+') {
                    sign = ops.peek();
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -ops.peek();
                    i++;
                } else if (s.charAt(i) == '(') {
                    ops.push(sign);
                    i++;
                } else if (s.charAt(i) == ')') {
                    ops.pop();
                    i++;
                } else {
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
                }
            }
            return ret;
        }
    }
}
