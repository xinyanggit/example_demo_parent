package com.yx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author test
 * @date 2021年03月17日
 * @time 4:38 下午
 * @since JDK1.8
 */
public class ListTest {
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
//        CollectionUtil.toList()
    }

    public static void main3(String[] args) {
        List arr  = new ArrayList();
        Object collect = arr.stream().map(str->!str.equals("")).collect(Collectors.toSet());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        Integer integer = list.stream().skip(2).findFirst().get();
        System.out.println(integer);
    }
    }
