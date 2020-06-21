package com.yx.sort;

import java.util.Arrays;

/**
 * @author yx start
 * @create 2020/6/21,16:17
 */
public class insertSort {
    public static void main(String[] args) {
        int[] insertNums = {4, 33, 10, 13, 49, 20, 8};
        // 插入排序调用
        insertSort(insertNums);
        System.out.println("插入排序后：" + Arrays.toString(insertNums));
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] nums) {
        int i, j, k;
        for (i = 1; i < nums.length; i++) {
            k = nums[i];
            j = i - 1;
            // 对 i 之前的数据，给当前元素找到合适的位置
            while (j >= 0 && k < nums[j]) {
                nums[j + 1] = nums[j];
                // j-- 继续往前寻找
                j--;
            }
            nums[j + 1] = k;
        }
    }
}
