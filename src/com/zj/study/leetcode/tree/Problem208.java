package com.zj.study.leetcode.tree;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/14 9:24 上午
 */
public class Problem208 {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
        obj.insert("wordd");
        System.out.println(obj.search("word"));
        System.out.println(obj.search("wordd"));
        System.out.println(obj.startsWith("prefix"));
    }

    private static class Trie {

        private boolean isEnd;
        private Trie[] children;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char tempChar = word.charAt(i);
                int tempIndex = tempChar - 'a';
                if (node.children[tempIndex] == null) {
                    node.children[tempIndex] = new Trie();
                }
                node = node.children[tempIndex];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char tempChar = prefix.charAt(i);
                int tempIndex = tempChar - 'a';
                if (node.children[tempIndex] == null) {
                    return null;
                }
                node = node.children[tempIndex];
            }
            return node;
        }
    }
}
