package com.zj.study.leetcode.string;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/20 9:07 上午
 */
public class Problem28_Method2 {
    public static void main(String[] args) {
        String haystack;
        String needle;
        Solution solution = new Solution();

        haystack = "hello";
        needle = "ll";
        System.out.println(solution.strStr(haystack, needle));
        haystack = "aaaaa";
        needle = "bba";
        System.out.println(solution.strStr(haystack, needle));
        haystack = "aabba";
        needle = "bba";
        System.out.println(solution.strStr(haystack, needle));

    }

    private static class Solution {
        public int strStr(String haystack, String needle) {
           return bm(haystack, needle);
        }

        /**
         * a,b只包含小写字母
         *
         * @param a 主串
         * @param b 模式串
         * @return
         */
        private int bm(String a, String b) {
            // 主串的长度
            int n = a.length();
            // 从串长度
            int m = b.length();
            // 记录模式串中每个字符最后出现的位置
            int[] bc = new int[26];
            int[] suffix = new int[m];
            boolean[] prefix = new boolean[m];
            generateBC(b, bc);
            generateGS(b, suffix, prefix);
            // i 表示主串与模式串对齐的第一个字符
            int i = 0;
            while (i <= n - m) {
                int j;
                // 模式串从后往前匹配
                for (j = m - 1; j >= 0; j--) {
                    if (a.charAt(i + j) != b.charAt(j)) {
                        // 坏字符串对应模式串中的下标是j
                        break;
                    }
                }
                if (j < 0) {
                    // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                    return i;
                }
                // 将模式串往后滑动 j - bc[a.chatAt(i + j] 位
                int x = j - bc[a.charAt(i + j) - 'a'];
                int y = 0;
                if (j < m - 1) {
                    y = moveByGS(j, m, suffix, prefix);
                }
                i = i + Math.max(x, y);
            }
            return -1;
        }

        // j 表示坏字符对应的模式串中的字符下标， m表示模式串的长度
        private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
            int k = m - 1 - j;// 好后缀长度
            if (suffix[k] != -1) return j - suffix[k] + 1;
            for (int r = j + 2; r <= m - 1; ++r) {
                if (prefix[m - r]) {
                    return r;
                }
            }
            return m;
        }

        private void generateBC(String string, int[] bc) {
            // 初始化
            for (int i = 0; i < bc.length; i++) {
                bc[i] = -1;
            }
            for (int i = 0; i < string.length(); i++) {
                bc[string.charAt(i) - 'a'] = i;
            }
        }

        /**
         * @param b      模式串
         * @param suffix suffix数组的下标k，表示后缀子串的长度，下标对应的数组值存储的是，再模式串中跟好数组后缀{u}相匹配的子串{u*}的起始下标值
         * @param prefix
         */
        private void generateGS(String b, int[] suffix, boolean[] prefix) {
            int m = b.length();
            // 初始化
            for (int i = 0; i < m; i++) {
                suffix[i] = -1;
                prefix[i] = false;
            }
            for (int i = 0; i < m - 1; i++) {
                // b[0,i]
                int j = i;
                // 公共后缀子串长度
                int k = 0;
                while (j >= 0 && b.charAt(j) == b.charAt(m - 1 - k)) { // 与 b[0, m - 1]求公共后缀子串
                    j--;
                    k++;
                    suffix[k] = j + 1; // j + 1表示公共后缀子串在b[0, i]中的初始下标
                }
                if (j == -1) {
                    // 如果公共后缀子串也是模式串的前缀子串
                    prefix[k] = true;
                }
            }
        }
    }
}
