package com.zj.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/16 2:13 下午
 */
public class Problem648 {

    public static void main(String[] args) {
        String sentence;
        List<String> dictionary;
        Solution solution = new Solution();

        dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        sentence = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dictionary, sentence));

        dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(solution.replaceWords(dictionary, sentence));

        dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(solution.replaceWords(dictionary, sentence));

        dictionary = new ArrayList<>();
        dictionary.add("catt");
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        sentence = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dictionary, sentence));

        dictionary = new ArrayList<>();
        dictionary.add("ac");
        dictionary.add("ab");
        sentence = "it is abnormal that this solution is accepted";
        System.out.println(solution.replaceWords(dictionary, sentence));
    }


    private static class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            Tree tree = new Tree();
            for (int i = 0; i < dictionary.size(); i++) {
                tree.insert(dictionary.get(i));
            }
            String[] strings = sentence.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                String search = tree.search(strings[i]);
                if (search != null) {
                    builder.append(" " + search);
                } else {
                    builder.append(" " + strings[i]);
                }

            }
            return builder.toString().substring(1);
        }

        private static class Tree {
            private Tree[] elements;
            private boolean isEnd = false;

            public Tree() {
                elements = new Tree[26];
                isEnd = false;
            }

            private void insert(String word) {
                Tree node = this;
                for (int i = 0; i < word.length(); i++) {
                    char tempChar = word.charAt(i);
                    int tempIndex = tempChar - 'a';
                    if (node.elements[tempIndex] == null) {
                        node.elements[tempIndex] = new Tree();
                    }
                    node = node.elements[tempIndex];
                }
                node.isEnd = true;
            }

            private String search(String word) {
                Tree node = this;
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    char tempChar = word.charAt(i);
                    int tempIndex = tempChar - 'a';
                    builder.append(tempChar);

                    if (node.elements[tempIndex] == null) {
                        return null;
                    }

                    if (node.elements[tempIndex].isEnd) {
                        return builder.toString();
                    }

                    node = node.elements[tempIndex];
                }
                return null;
            }
        }
    }
}
