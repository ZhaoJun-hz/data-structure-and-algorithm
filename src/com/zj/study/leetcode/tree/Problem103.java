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
public class Problem103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();
        int rowSize = 1;
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (height %  2  == 0) {
                temp.add(treeNode.val);
            }else {
                temp.add(0, treeNode.val);
            }
            rowSize --;
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right  != null) {
                queue.offer(treeNode.right);
            }
            if (rowSize == 0) {
                height ++;
                result.add(temp);
                temp = new ArrayList<>();
                rowSize  =  queue.size();
            }
        }
        return result;
    }
}
