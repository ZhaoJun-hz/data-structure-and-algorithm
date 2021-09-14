package com.zj.study.love.tree;


import com.zj.study.love.tree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @author zj
 * @desiription:
 * @date 2021/8/16 5:26 下午
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        // Integer data[] = new Integer[] {7, 4, 9, 2, 5, 8, 11, 3, 13,15, 16};
        // Integer data[] = new Integer[] {7, 4, 9, 2, 5, 8, 11, 3, 13, 15, 16};
        // Integer data[] = new Integer[] {13, 14, 15, 12, 11, 17, 16, 8, 9, 1};
        Integer data[] = new Integer[] {13, 14, 15, 12, 11, 17, 16, 8, 9, 1};
        AVLTree<Integer> avlTree = new AVLTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        for (int i = 0; i < data.length; i++) {
            avlTree.add(data[i]);
        }
        BinaryTrees.println(avlTree);

        System.out.println("-------------------");
        avlTree.remove(14);
        BinaryTrees.println(avlTree);

        System.out.println("-------------------");
        avlTree.remove(16);
        BinaryTrees.println(avlTree);

        System.out.println("-------------------");
        avlTree.remove(17);
        BinaryTrees.println(avlTree);
    }
}
