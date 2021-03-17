package com.yx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxin@webull.com
 * @date 2021年03月17日
 * @time 4:38 下午
 * @since JDK1.8
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
//        CollectionUtil.toList()
    }
}
