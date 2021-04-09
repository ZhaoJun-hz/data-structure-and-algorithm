package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/8 6:34 下午
 */
public class Problem1656 {
    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }

    private static class OrderedStream {

        private String[] save;
        private int ptr = 1;
        private int count;

        public OrderedStream(int n) {
            save = new String[n + 1];
            this.count = n;
        }

        public List<String> insert(int idKey, String value) {
            List<String> result = new ArrayList<>();
            save[idKey] = value;
            if (idKey != ptr) {
                return result;
            }
            while (true) {
                if (save[idKey] != null) {
                    result.add(save[idKey ++]);
                }else {
                    break;
                }
                if(idKey > count) {
                    break;
                }
            }
            ptr = idKey;
            return result;
        }
    }
}
