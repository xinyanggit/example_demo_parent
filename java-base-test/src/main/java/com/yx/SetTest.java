package com.yx;

import java.util.HashSet;
import java.util.Set;

/**
 * @author test
 * @date 2021年04月12日
 * @time 10:56 上午
 * @since JDK1.8
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        Set<String> set2 = new HashSet<>();
        set2.add("3");
        set2.add("4");
        System.out.println(set1.size());
        set1.removeAll(set2);
        System.out.println(set1.size());

    }
}
