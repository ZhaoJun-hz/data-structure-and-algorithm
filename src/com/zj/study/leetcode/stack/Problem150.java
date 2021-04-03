package com.zj.study.leetcode.stack;

import java.util.Stack;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/1 6:29 下午
 */
public class Problem150 {
    public static void main(String[] args) {
        String[] tokens;
        Solution solution = new Solution();

        tokens = new String[]{"2","1","+","3","*"};
        System.out.println(solution.evalRPN(tokens));
        tokens = new String[]{"4","13","5","/","+"};
        System.out.println(solution.evalRPN(tokens));
        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(tokens));
        tokens = new String[]{"4","3","-"};
        System.out.println(solution.evalRPN(tokens));
    }

    private static class Solution {
        public int evalRPN(String[] tokens) {
            int result = 0;
            Stack<Integer> numbers = new Stack<>();
            for(String temp : tokens) {
                if(judgeNumber(temp)) {
                    numbers.push(new Integer(temp));
                }else {
                    Integer next = numbers.pop();
                    Integer pre = numbers.pop();
                    result = calTwo(pre, next, temp);
                    numbers.push(result);
                }
            }
            return numbers.pop();
        }

        private int calTwo(Integer pre, Integer next, String operator) {
            switch (operator) {
                case "+": return pre + next;
                case "-": return pre - next;
                case "*": return pre * next;
                case "/": return pre / next;
            }
            return 0;
        }

        private boolean judgeNumber(String temp) {
            if (temp.charAt(0) == '-' ) {
                if(temp.length() > 1) {
                    return true;
                }
                return false;
            }
            if(temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
                return true;
            }
            return false;
        }
    }
}
