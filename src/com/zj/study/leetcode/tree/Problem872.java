package com.zj.study.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/5/10 4:13 下午
 */
public class Problem872 {

    private static class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = inorderTraversal(root1);
            List<Integer> list2 = inorderTraversal(root2);
            if(list1.size() != list2.size()) {
                return false;
            }

            for (int i = 0; i < list1.size(); i++) {
                if(list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            // root为空且stack为空，遍历结束
            while (root != null || !stk.isEmpty()) {
                // 一直遍历到左子树最下边, 边遍历边保存根节点到栈中
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                if (root.left == null && root.right == null) {
                    res.add(root.val);
                }
                root = root.right;
            }
            return res;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
