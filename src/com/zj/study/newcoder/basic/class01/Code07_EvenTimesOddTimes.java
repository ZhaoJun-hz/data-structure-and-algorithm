package com.zj.study.newcoder.basic.class01;

public class Code07_EvenTimesOddTimes {

    public static void printOddTimesNum1(int[] arr) {
        int eO = 0;
        for (int cur : arr) {
            eO ^= cur;
        }
        System.out.println(eO);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for(int num : arr) {
            eor ^= num;
        }
        // eor = a ^ b
        // eor != 0
        // eor 必有一个位置不为1
        int rightOne = eor & (~eor + 1);  // 提取出最右1
        int onlyOne = 0;
        for (int num : arr) {
            if ((num & rightOne) == 0) {
                onlyOne ^= num;
            }
        }
        System.out.println(onlyOne + "   " + (onlyOne ^ eor));
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
