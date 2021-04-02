package com.zj.study.leetcode.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/1 2:15 下午
 */
public class Problem1006 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clumsy(1));
        System.out.println(solution.clumsy(4));
        System.out.println(solution.clumsy(10));
    }

    private static class Solution {
        public int clumsy(int N) {
            // 获取表达式
            String expression = getExpression(N);

            // 将表达式转成后缀表达式
            ArrayList<String> suffix = getSuffix(expression);
            return calculate(suffix);
        }

        // 后缀表达式求值
        private int calculate(ArrayList<String> suffix) {
            int result = 0;
            Stack<Integer> numbers = new Stack<>();
            for(String temp : suffix) {
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

        private ArrayList<String> getSuffix(String expression) {
            String[] strings = expression.split(" ");
            ArrayList<String> suffix = new ArrayList<>();  // 保存后缀表达式
            Stack<String> operator = new Stack<>();
            for (String temp : strings) {
                // 遇到数字,直接输出到后缀表达式
                if (judgeNumber(temp)) {
                    suffix.add(temp);
                }else {
                    if(temp.equals("(")) {
                        // 遇到(,入栈
                        operator.push(temp);
                    }else if(temp.equals(")")) {
                        // 遇到), 出栈,直到(
                        String topOperator = null;
                        while (!(topOperator = operator.pop()).equals("(")) {
                            suffix.add(topOperator);
                        }
                    }else {
                        // 遇到运算符
                        // 出栈, 直到栈顶操作符的优先级大于当前操作符的优先级
                        while (!operator.isEmpty() && operatorPriority(temp) <= operatorPriority(operator.peek())) {
                            suffix.add(operator.pop());
                        }
                        operator.push(temp); // 当前操作符入栈
                    }
                }
            }
            if (!operator.isEmpty()) {
                while (!operator.isEmpty()) {
                    suffix.add(operator.pop());
                }
            }
            return suffix;
        }

        private int operatorPriority(String s) {
            switch (s) {
                case "(":
                    return 1;
                case "+":
                case "-":
                    return 2;
                case "*":
                case "/":
                    return 3;
            }
            return -1;
        }

        private boolean judgeNumber(String temp) {
            if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
                return true;
            }
            return false;
        }

        private String getExpression(int n) {
            StringBuilder builder = new StringBuilder();
            int temp = 0;
            for (int i = n; i >= 1; i--) {
                builder.append(" " +i);
                if (i != 1) {
                    int operator = temp % 4;
                    if (operator == 0) {
                        builder.append(" *");
                    }else if (operator == 1) {
                        builder.append(" /");
                    }else if (operator == 2) {
                        builder.append(" +");
                    }else if (operator == 3) {
                        builder.append(" -");
                    }
                    temp++;
                }
            }
            return builder.toString().substring(1);
        }
    }
}
