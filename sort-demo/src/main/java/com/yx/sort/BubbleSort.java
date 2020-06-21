package com.yx.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author yx start
 * @create 2020/6/21,15:36
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 待排序数组
        int[] arrays = {44, 22, 66, 33, 55, 123, 3213, 56, 31};
        bubbleSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * 冒泡排序
     *
     * @param arrays
     */
    private static void bubbleSort(int[] arrays) {
        int length = arrays.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    // 前面的数据大于后面的，需要调换
                    int tmp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
    }


}
