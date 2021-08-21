package com.zj.study.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/20 3:06 下午
 */
public class Problem637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int rowSize = 1;
        int tempRowSize = 1;
        long sum = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            sum += treeNode.val;
            rowSize --;
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right  != null) {
                queue.offer(treeNode.right);
            }
            if (rowSize == 0) {
                result.add(sum * 1.0 / tempRowSize);
                rowSize  =  queue.size();
                tempRowSize = rowSize;
                sum = 0;
            }
        }
        return result;
    }
}
