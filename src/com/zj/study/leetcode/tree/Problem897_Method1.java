package com.zj.study.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/25 2:25 下午
 */
public class Problem897_Method1 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return new TreeNode();
            }

            TreeNode treeNode = new TreeNode();
            TreeNode temp = treeNode;
            Deque<TreeNode> stk = new LinkedList<>();
            // root为空且stack为空，遍历结束
            while (root != null || !stk.isEmpty()) {
                // 一直遍历到左子树最下边, 边遍历边保存根节点到栈中
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                temp.right = new TreeNode(root.val, null, null);
                temp = temp.right;
                root = root.right;
            }
            return treeNode.right;
        }
    }
}
