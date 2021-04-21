package com.zj.study.leetcode.queue;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/20 10:59 上午
 */
public class Problem622_Method1 {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1)); // true
        System.out.println(obj.enQueue(2)); // true
        System.out.println(obj.enQueue(3)); // true
        System.out.println(obj.enQueue(4)); // false
        System.out.println(obj.Rear()); // 3
        System.out.println(obj.isFull()); // true
        System.out.println(obj.deQueue());// true
        System.out.println(obj.enQueue(4)); // true
        System.out.println(obj.Rear()); // 4
        System.out.println("----------------");
        obj = new MyCircularQueue(2);
        System.out.println(obj.enQueue(1)); // true
        System.out.println(obj.deQueue()); // true
        System.out.println(obj.isFull()); // false
        System.out.println(obj.isEmpty()); // true
        System.out.println("---------------");
        obj = new MyCircularQueue(2);
        System.out.println(obj.enQueue(4)); // true
        System.out.println(obj.Rear()); // 4
        System.out.println(obj.enQueue(9)); // true
        System.out.println(obj.deQueue()); // true
        System.out.println(obj.Front()); // 9
        System.out.println(obj.deQueue()); // true
        System.out.println(obj.deQueue()); // false
        System.out.println(obj.isEmpty()); // true
        System.out.println(obj.deQueue()); // false
        System.out.println(obj.enQueue(6)); // true
        System.out.println(obj.enQueue(4)); // true

    }

    private static class MyCircularQueue {
        private int length;
        private int head;
        private int tail;
        private int[] nums;

        public MyCircularQueue(int k) {
            nums = new int[k];
            length = k;
            head = -1;
            tail = -1;
        }

        public boolean enQueue(int value) {
            if ((tail + 1) % length == head) {
                return false;
            }
            if (head == -1) head = 0;
            nums[(tail + 1) % length] = value;
            tail = (tail + 1) % length;
            return true;
        }

        public boolean deQueue() {
            if (head == tail && head == -1) {
                return false;
            }
            if(head == tail) {
                head = -1;
                tail = -1;
            }else {
                head = (head + 1) % length;
            }
            return true;
        }

        public int Front() {
            if (head == tail && head == -1) {
                return -1;
            }
            return nums[head];
        }

        public int Rear() {
            if (head == tail && head == -1) {
                return -1;
            }
            return nums[tail];
        }

        public boolean isEmpty() {
            if (head == tail && head == -1) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if ((tail + 1) % length == head) {
                return true;
            }
            return false;
        }
    }
}
