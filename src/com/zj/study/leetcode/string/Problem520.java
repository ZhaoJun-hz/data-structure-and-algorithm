package com.zj.study.leetcode.string;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/19 3:40 下午
 */
public class Problem520 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
        System.out.println(solution.detectCapitalUse("abcdefg"));
        System.out.println(solution.detectCapitalUse("abcdefgABC"));
        System.out.println(solution.detectCapitalUse("Leetcode"));

    }

    private static class Solution {
        public boolean detectCapitalUse(String word) {
            if(word.length() == 1) return true;
            int result = -1;
            if(word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
                // 全部小写
                result = 0;
            }else if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
                if(word.charAt(1) >= 'a' && word.charAt(1) <= 'z'){
                    // Aa...
                    result = 1;
                }else {
                    // AA
                    result = 2;
                }
            }
            for (int i = 1; i < word.length(); i++) {
                if(i == 1) {
                    if(result == 1 || result == 2) continue;
                }
                if(result == 0) {
                    if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                        return false;
                    }
                }else if(result == 1) {
                    if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                        return false;
                    }
                }else if(result == 2) {
                    if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
