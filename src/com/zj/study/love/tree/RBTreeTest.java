package com.zj.study.love.tree;

import com.zj.study.love.tree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @author zj
 * @desiription:
 * @date 2021/9/7 8:49 上午
 */
public class RBTreeTest {
    public static void main(String[] args) {
        Integer data[] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        RBTree<Integer> rbTree = new RBTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
            BinaryTrees.println(rbTree);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
