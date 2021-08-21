package com.zj.study.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/20 3:06 下午
 */
public class Problem111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        int rowSize = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            rowSize --;
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            if(treeNode.left == null && treeNode.right == null) {
                break;
            }
            if(rowSize == 0) {
                rowSize = queue.size();
                if (rowSize > 0) {
                    height++;
                }
            }
        }
        return height;
    }
}
